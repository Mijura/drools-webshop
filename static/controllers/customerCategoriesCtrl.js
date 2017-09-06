(function() {
	// controller bound to application body, parent controller to all others
	angular.module("myApp").controller('customerCategoriesController', customerCategoriesController);
	
	function customerCategoriesController($scope, $http, $cookies, toastr) {
		var vm = this;
		vm.view=-1;
		
		if($cookies.getObject('userdata')!=undefined){
			vm.userData = $cookies.getObject('userdata');
		}else{
			vm.userData = {};
			vm.view = 0;
		}	
		
		$http.post('/api/manager/getCategories').then(function(response) {
			
			if(response.data){
				vm.categories = response.data;
				vm.view = 1;
			}
		}, function(response) {
			toastr.error("Access Denied!");
		});	
		
		vm.showCategory = function(){
			vm.limits = vm.selectedCategory.limits;
			vm.edit = undefined;
			vm.index = -1;
		}
		
		vm.setEditCategory = function(i){
			vm.index = i;
			vm.edit = JSON.parse(JSON.stringify(vm.limits[i]));
			vm.edit.fromLimit = Number(vm.edit.fromLimit);
			vm.edit.toLimit = Number(vm.edit.toLimit);
			
			if(vm.index==0){
				vm.min=0;
				vm.minDiscount = 1;
			}
			else{
				vm.min=vm.limits[vm.index-1].fromLimit;
				vm.minDiscount = vm.limits[vm.index-1].priceToPoints;
			}
				
			if(vm.index==vm.limits.length-1){
				vm.max=Number.POSITIVE_INFINITY;
				vm.maxDiscount = 100;
			}else{
				vm.max=vm.limits[vm.index+1].toLimit;
				vm.maxDiscount = vm.limits[vm.index+1].priceToPoints;
			}
				
			
			 
		}
		
		vm.editCustomerCategory = function(){
			
			
			if(vm.edit.fromLimit<vm.min || vm.edit.fromLimit>vm.max){
				toastr.error("Down limit isn't valid. (Valid range ["+vm.min+","+vm.max+"])");
				return;
			}
			else if(vm.edit.toLimit<vm.min || vm.edit.toLimit>vm.max){
				toastr.error("Up limit isn't valid. (Valid range ["+vm.min+","+vm.max+"])");
				return;
			}else if(vm.edit.fromLimit>vm.edit.toLimit){
				toastr.error("Down limit is upper than up limit.");
				return;
			}
			
			if(vm.edit.priceToPoints<vm.minDiscount || vm.edit.priceToPoints>vm.maxDiscount){
				toastr.error("Discount isn't valid. (Valid range ["+vm.minDiscount+","+vm.maxDiscount+"])");
				return;	
			}
			
			vm.limits[vm.index].priceToPoints = vm.edit.priceToPoints;
			
			vm.change=[];
			vm.change.push(vm.edit);
			
			if(vm.edit.fromLimit!=vm.limits[vm.index].fromLimit){
				vm.limits[vm.index].fromLimit = vm.edit.fromLimit;
				if(vm.index!=0){
					vm.limits[vm.index-1].toLimit = vm.edit.fromLimit;
					vm.change.push(vm.limits[vm.index-1]);
				}
					
			}
			
			if(vm.edit.toLimit!=vm.limits[vm.index].toLimit){
				vm.limits[vm.index].toLimit = vm.edit.toLimit;
				if(vm.index!=vm.limits.length-1){
					vm.limits[vm.index+1].fromLimit = vm.edit.toLimit;
					vm.change.push(vm.limits[vm.index+1]);
				}
			}
			
			$http.post('/api/manager/changeCustomerCategories', vm.change).then(function(response) {	
				toastr.success("Customer categories are successfully changed!");
				vm.edit = undefined;
				vm.index = -1;
			}, function(response) {
				toastr.error("Access Denied!");
			});	
			
				
		}
		
	}
    
})();