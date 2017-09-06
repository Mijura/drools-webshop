(function() {
	// controller bound to application body, parent controller to all others
	angular.module("myApp").controller('articleCategoriesController', articleCategoriesController);
	
	function articleCategoriesController($scope, $http, $window, $cookies, toastr) {
		var vm = this;
		vm.view=-1;
		
		if($cookies.getObject('userdata')!=undefined){
			vm.userData = $cookies.getObject('userdata');
		}else{
			vm.userData = {};
			vm.view = 0;
		}	
		
		$http.post('/api/manager/getArticleCategories').then(function(response) {
			
			if(response.data){
				vm.categories = response.data;
				vm.view = 1;
			}
		}, function(response) {
			toastr.error("Access Denied!");
		});	
		
		vm.setEditCategory = function(i){
			vm.newCategory=false;
			vm.index = i;
			vm.edit = JSON.parse(JSON.stringify(vm.categories[i]));

			if(vm.edit.superCategory!=null)
				vm.superCategory = vm.edit.superCategory.id;
			else
				vm.superCategory = null;
			vm.superCategories = [];
			vm.superCategories.push(null);
			vm.categories.forEach(function(x) {
				if(x.id!=vm.edit.id)
					vm.superCategories.push(x.id);
			});
			
		
		}
		
		vm.editArticleCategory = function(){
			
			if(vm.superCategory)
				vm.categories.forEach(function(x) {
					if(x.id==vm.superCategory){
						vm.edit.superCategory = x;
					}
				});
			else
				vm.edit.superCategory=null;
				
			$http.post('/api/manager/editArticleCategories', vm.edit).then(function(response) {
				
				if(response.data){
					vm.categories = response.data;
					vm.edit = null;
					toastr.success("Article category is successfully changed!");
				}
			}, function(response) {
				toastr.error("Access Denied!");
			});	
		}
		
		vm.addArticleCategory = function(){
			if(!vm.newId || !vm.newName || !vm.newMaxDiscount){
				toastr.error("All fields except Super Category must be filled!");
				return ;
			}
			
			if(vm.newSuperCategory==undefined)
				vm.newSuperCategory=null;
			
			data={"id":vm.newId, "name": vm.newName, "maxDiscount": vm.newMaxDiscount, "superCategory": vm.newSuperCategory}
			
			$http.post('/api/manager/addArticleCategories', data).then(function(response) {
				
				if(response.data){
					vm.categories = response.data;
					vm.newCategory = false; vm.newId=''; vm.newName=''; vm.newMaxDiscount='';
					toastr.success("Article category is successfully added!");
				}else{
					toastr.error("Already exist article category with entered ID!");
				}
			}, function(response) {
				toastr.error("Access Denied!");
			});	

		};
		
	}
    
})();