(function() {
	// controller bound to application body, parent controller to all others
	angular.module("myApp").controller('indexController', indexController);
	
	function indexController($cookies, toastr) {
		var vm = this;
		vm.loggedIn = false;
		isLogged();
		
		function isLogged() {
			if($cookies.get("userdata") != undefined){
				vm.loggedIn = true;
				vm.userData = $cookies.getObject("userdata");
			}
		}
		
		vm.login = function(token){
			vm.loggedIn = true;
			vm.userData = parseJwt(token);
			vm.role = vm.userData.iss;
			$cookies.putObject('userdata', vm.userData);
			$cookies.put('token', token);
		}
		
		vm.logout = function() {
			vm.loggedIn = false;
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