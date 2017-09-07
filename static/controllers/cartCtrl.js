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
		
		vm.getDiscounts = function(){
			alert(JSON.stringify($scope.cart));
		}
	}
    
})();