(function() {
	// controller bound to application body, parent controller to all others
	angular.module("myApp").controller('loginController', loginController);
	
	function loginController($scope, $http, toastr) {
		var vm = this;
		
		vm.login = function(){
			
			if(!vm.username || !vm.password){
				toastr.error("Enter all fields!");
				return ;
			}
				
			var userData =  { "username": vm.username, "password": vm.password };
	        
			$http.post('/api/users/login', userData).then(function(response) {
				
				$scope.indexCtrl.login(response.data.response);
				toastr.success(vm.username + " welcome!");
				

			}, function(response) {
				toastr.error(response.data.response);
			});
		}
	}
    
})();