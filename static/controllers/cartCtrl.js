(function() {
	// controller bound to application body, parent controller to all others
	angular.module("myApp").controller('cartController', cartController);
	
	function cartController($rootScope, $scope, $cookies, $http, toastr) {
		var vm = this;
		vm.view = true;
		vm.receipt = null;
		
		vm.cartPrice = 0;

		angular.forEach($rootScope.cart, function(x) {
			vm.cartPrice = Math.round((vm.cartPrice + x.price*x.amount) * 100) / 100;
		});
		
		vm.calcImage = function(id){
			return "images/articles/"+btoa(id)+".jpg"
		}
		
		vm.calcFinalPrice = function(x){
			return Math.round((x.amount*x.price) * 100) / 100;
		}
		
		var roundPrice = function(x){
			return Math.round(x * 100) / 100;
		}
		
		vm.getDiscounts = function(){

			$http.post('/api/customer/getDiscounts', $rootScope.cart).then(function(response) {
				
				if(response.data){
					vm.receipt = response.data;
					vm.receipt.finalPrice = roundPrice(vm.receipt.finalPrice);

					if(parseInt(Math.ceil(vm.receipt.finalPrice))<parseInt($scope.indexCtrl.userData.points))
						vm.max = parseInt(Math.ceil(vm.receipt.finalPrice));
					else
						vm.max = parseInt($scope.indexCtrl.userData.points);
				}
			}, function(response) {
				toastr.error("Access Denied!");
			});
		}
		
		vm.createReceipt = function(){
			if(parseInt(Math.ceil(vm.spentPoints))>parseInt($scope.indexCtrl.userData.points)){
				toastr.error("You entered more points than you have");
				return;
			}
			if(vm.spentPoints==undefined){
				vm.spentPoints=0;
			}else if(vm.spentPoints>vm.max)
				vm.spentPoints=vm.max;
			
			$scope.indexCtrl.userData.points = $scope.indexCtrl.userData.points - vm.spentPoints;
			vm.receipt.customer.points = vm.receipt.customer.points - vm.spentPoints;
			vm.receipt.spentPoints = vm.spentPoints;
			if(vm.receipt.earnedPoints==null)vm.receipt.earnedPoints=0;
			vm.receipt.state="ON HOLD";
			
			alert(JSON.stringify(vm.receipt));
			$http.post('/api/customer/createReceipt', vm.receipt).then(function(response) {
				if(response.data){
					
					$rootScope.cart = [];
					$cookies.put('cart',[]);
					
					vm.cartPrice = 0;
					$scope.indexCtrl.cartPrice=undefined;
					$scope.indexCtrl.itemNumber=undefined;
					toastr.success("Receipt was sent to Salesman");
					
					vm.view=false;
					vm.view2=true;
					
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
				toastr.error("Access Denied!");
			});
		}
		
	}
    
})();