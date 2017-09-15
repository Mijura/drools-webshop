(function() {
	// controller bound to application body, parent controller to all others
	angular.module("myApp").controller('receiptController', receiptController);
	
	function receiptController($scope, $http, $routeParams, toastr) {
		var vm = this;
		vm.view=false;
		
		var data =  { 
				"id": parseInt($routeParams.id)
			};
		
		$http.post('api/customer/getReceipt', data).then(function(response) {
			
			if(response.data){
				vm.receipt = response.data;
				vm.view=true;
				vm.articles = [];
				vm.itemDiscounts=[];
				
				angular.forEach(vm.receipt.items, function(x) {
					vm.articles.push({"id":x.article.id, "name":x.article.name, "category":x.article.category,
						"price":x.article.price, "amount":x.amount, "final":x.amount*x.article.price})
					
						angular.forEach(x.itemDiscounts, function(id) {
						vm.itemDiscounts.push({"id":x.article.id, "name":x.article.name,
							"type":id.type,"discount":id.discount});
						});
					
					
					}
				);
			}

		}, function(response) {
			toastr.error(response.data, 'Error');
		});
		
		vm.calcImage = function(id){
			return "images/articles/"+btoa(id)+".jpg"
		}
		
		vm.calcFinalPrice = function(x){
			return Math.round((x.amount*x.price) * 100) / 100;
		}
	
		
	}
    
})();