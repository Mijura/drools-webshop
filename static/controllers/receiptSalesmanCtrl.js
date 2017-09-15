(function() {
	// controller bound to application body, parent controller to all others
	angular.module("myApp").controller('receiptSalesmanController', receiptSalesmanController);
	
	function receiptSalesmanController($scope, $http, $window, $routeParams, toastr) {
		var vm = this;
		vm.view=false;
		
		var data =  { 
				"id": parseInt($routeParams.id)
			};
		
		$http.post('api/salesman/getReceipt', data).then(function(response) {
			
			if(response.data){
				vm.receipt = response.data;
				vm.view=true;
				vm.articles = [];
				vm.itemDiscounts=[];
				
				vm.ok=true;
				
				angular.forEach(vm.receipt.items, function(x) {
					
					if(parseInt(x.article.count)-parseInt(x.amount)<0)
						vm.ok=false;
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
		
		vm.calcIcon = function(x,y){
			if(parseInt(x)-parseInt(y)<0)
				return false;
			else
				return true;
		}
		
		vm.acceptReceipt = function(){
			var data =  { 
					"id": parseInt($routeParams.id)
				};
			
			$http.post('api/salesman/acceptReceipt', data).then(function(response) {
				toastr.success("Receipt is accepted.");
				$window.location = "#!/dashboard";
			}, function(response) {
				toastr.error(response.data, 'Error');
			});
			
		}
		
		vm.declineReceipt = function(){
			var data =  { 
					"id": parseInt($routeParams.id)
				};
			
			$http.post('api/salesman/declineReceipt', data).then(function(response) {
				toastr.success("Receipt is declined.");
				$window.location = "#!/dashboard";
			}, function(response) {
				toastr.error(response.data, 'Error');
			});
		}
	
		
	}
    
})();