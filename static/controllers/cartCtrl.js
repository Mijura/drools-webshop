(function() {
	// controller bound to application body, parent controller to all others
	angular.module("myApp").controller('cartController', cartController);
	
	function cartController($scope, $http, toastr) {
		var vm = this;
		vm.view = true;
		
		vm.cartPrice = 0;
		$scope.cart.forEach(function(x) {
			vm.cartPrice = Math.round((vm.cartPrice + x.price*x.amount) * 100) / 100;
		});
		
		vm.calcImage = function(id){
			return "images/articles/"+btoa(id)+".jpg"
		}
		
		vm.calcFinalPrice = function(x){
			return Math.round((x.amount*x.price) * 100) / 100;
		}
		
		
		vm.getDiscounts = function(){

			$http.post('/api/customer/getDiscounts', $scope.cart).then(function(response) {
				
				if(response.data){
					
					response.data.items.forEach(function(x) {
						alert(JSON.stringify(x.finalPrice));
						alert(JSON.stringify(x.itemDiscounts));
					});
					
					//vm.articles = response.data;
					//vm.view = 1;
				}
			}, function(response) {
				toastr.error("Access Denied!");
			});
		}
	}
    
})();