(function() {
	// controller bound to application body, parent controller to all others
	angular.module("myApp").controller('profileController', profileController);
	
	function profileController($scope, $cookies, $http, toastr) {
		var vm = this;
		
		if($cookies.getObject('userdata')!=undefined){
			vm.userData = $cookies.getObject('userdata');
			var d = new Date(vm.userData.registered*1000);
			vm.date = d.toString("dd/mm/yyyy");
		}else{
			vm.userData = {};
			vm.view = 0;
		}
		$http.post('/api/customer/getReceipts').then(function(response) {
			
			if(response.data){
				vm.receipts = response.data;
				vm.view = 1;
			}
		}, function(response) {
			toastr.error("Access Denied!");
		});	
		
		function formatDate(date) {
			var d = new Date(date*1000),
		        month = '' + (d.getMonth() + 1),
		        day = '' + d.getDate(),
		        year = d.getFullYear();

		    if (month.length < 2) month = '0' + month;
		    if (day.length < 2) day = '0' + day;

		    return [year, month, day].join('-');
		}
		
		vm.calcDate = function(date){
	
			return d.getDay()+"/"+d.getMonth()+"/"+d.getYear();
		}
	}
    
})();