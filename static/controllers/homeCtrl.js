(function() {
	// controller bound to application body, parent controller to all others
	angular.module("myApp").controller('homeController', homeController);
	
	function homeController($scope, $http, $cookies, $window, toastr) {
		var vm = this;
		
		if($cookies.getObject('userdata')!=undefined){
			vm.userData = $cookies.getObject('userdata');
		}else{
			vm.userData = {};
			vm.view = 0;
		}	
		
		$http.post('/api/customer/getArticles').then(function(response) {
			
			if(response.data){
				vm.articles = response.data;
				vm.view = 1;
			}
		}, function(response) {
			toastr.error("Access Denied!");
		});
		
		vm.calcImage = function(id){
			return "images/articles/"+btoa(id)+".jpg"
		}
	}
    
})();