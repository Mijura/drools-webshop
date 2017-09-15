(function() {
	// controller bound to application body, parent controller to all others
	angular.module("myApp").controller('indexController', indexController);
	
	function indexController($rootScope,$scope, $cookies, $window, toastr) {
		var vm = this;
		vm.loggedIn = false;
		
		isLogged();
		
		function isLogged() {
			if($cookies.get("userdata") != undefined){
				vm.loggedIn = true;
				vm.homepage = '#!/home';
				vm.userData = $cookies.getObject("userdata");
				if(vm.userData.role=='customer'){
					$rootScope.cart = $cookies.getObject("cart");
				}
			}
			
			
		}
		
		vm.calcCartPrice = function(){
			vm.cartPrice=0;
			$rootScope.cart.forEach(function(x) {
				vm.cartPrice = Math.round((vm.cartPrice + x.price*x.amount) * 100) / 100;
				
			});
			vm.itemNumber = $rootScope.cart.length;
		}
		
		vm.addToCart = function(article){
			if(!article.amount){
				toastr.error("Enter amount!");
				return;
			}
			
			var find = false;
			angular.forEach($rootScope.cart, function(x) {
				if(x.id==article.id){
					x.amount = x.amount + article.amount;
					find=true;
				}
					
			});
			
			if(!find){
				$rootScope.cart = $rootScope.cart || [];
				$rootScope.cart.push(JSON.parse(JSON.stringify(article)));
			}
				
			
			vm.calcCartPrice();
			toastr.success("Succesfully added article to chart");
			$cookies.putObject('cart',$rootScope.cart);
		}
		
		vm.login = function(token){
			vm.loggedIn = true;
			vm.userData = parseJwt(token);
			vm.role = vm.userData.iss;
			$cookies.putObject('userdata', vm.userData);
			$cookies.put('token', token);
			
			if(vm.userData.role=="customer"){
				$window.location = "#!/home";
				$rootScope.cart = [];
				$cookies.putObject('cart',$rootScope.cart);
			}
			else if(vm.userData.role=='manager')
				$window.location = "#!/customerCategories";
			else
				$window.location = "#!/dashboard";
		}
		
		vm.logout = function() {
			vm.loggedIn = false;
			vm.homepage = '#!/';
			toastr.success(vm.userData.username + " godbye.");
			vm.userData = undefined;
			var cookies = $cookies.getAll();
			for ( var x in cookies) {
				$cookies.remove(x);
			}	
		};
		
		function parseJwt (token) {
            var base64Url = token.split('.')[1];
            var base64 = base64Url.replace('-', '+').replace('_', '/');
            return JSON.parse(window.atob(base64));
        };
		
		
	}
    
})();