(function() {
	// controller bound to application body, parent controller to all others
	angular.module("myApp").controller('dashboardController', dashboardController);
	
	function dashboardController($scope, $http, toastr) {
		var vm = this;
		
		
		$http.post('/api/salesman/getAllReceipts').then(function(response) {
			
			if(response.data){
				vm.receipts = response.data;
				vm.view = 1;
			}
			
		}, function(response) {
			toastr.error("Access Denied!");
		});	
		
		vm.ch=function(){
			vm.state=vm.m;
		}
		
	}
    
})();