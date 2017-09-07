(function() {
	// controller bound to application body, parent controller to all others
	angular.module("myApp").controller('indexController', indexController);
	
	function indexController($scope, $cookies, $window, toastr) {
		var vm = this;
		vm.loggedIn = false;
		$scope.cart = [];
		
		isLogged();
		
		function isLogged() {
			if($cookies.get("userdata") != undefined){
				vm.loggedIn = true;
				vm.homepage = '#!/home';
				vm.userData = $cookies.getObject("userdata");
			}
			
			
		}
		
		function calcCartPrice(){
			vm.cartPrice=0;
			$scope.cart.forEach(function(x) {
				vm.cartPrice = Math.round((vm.cartPrice + x.price*x.amount) * 100) / 100;
				
			});
		}
		
		vm.addToChart = function(article){
			if(!article.amount){
				toastr.error("Enter amount!");
				return;
			}
			
			var find = false;
			$scope.cart.forEach(function(x) {
				if(x.id==article.id){
					x.amount = x.amount + article.amount;
					find=true;
				}
					
			});
			
			if(!find)
				$scope.cart.push(JSON.parse(JSON.stringify(article)));
			
			calcCartPrice();
			toastr.success("Succesfully added article to chart");
		}
		
		vm.login = function(token){
			vm.loggedIn = true;
			vm.userData = parseJwt(token);
			vm.role = vm.userData.iss;
			$cookies.putObject('userdata', vm.userData);
			$cookies.put('token', token);
			
			if(vm.userData.role=="customer"){
				$window.location = "#!/home";
				
			}
			else if(vm.userData.role=='manager')
				$window.location = "#!/customerCategories";
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