(function() {
	// controller bound to application body, parent controller to all others
	angular.module("myApp").controller('saleController', saleController);
	
	function saleController($scope, $http, $cookies, $window, toastr) {
		var vm = this;
		
		var vm = this;
		vm.view=-1;
		
		if($cookies.getObject('userdata')!=undefined){
			vm.userData = $cookies.getObject('userdata');
		}else{
			vm.userData = {};
			vm.view = 0;
		}	
		
		$http.post('/api/manager/getSales').then(function(response) {
			
			if(response.data){
				vm.sales = response.data;
				vm.view = 1;
			}
		}, function(response) {
			toastr.error("Access Denied!");
		});	
		
		$http.post('/api/manager/getArticleCategories').then(function(response) {
			
			if(response.data){
				vm.categories = response.data;
				vm.ac = {}
				vm.temp = {}
				vm.categories.forEach(function(x) {
					vm.ac[x.id]=false;
					vm.temp[x.id]=x;
				});
			}
		}, function(response) {
			toastr.error("Access Denied!");
		});	
		
		vm.setEditSale = function(i){
			vm.newSale=false;
			vm.index = i;
			vm.edit = JSON.parse(JSON.stringify(vm.sales[i]));
		}
		
		vm.formatDate = function(date){
	          var dateOut = new Date(date);
	          return dateOut;
	    };
	    
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
		
		function parseDate(date){
        	var d = date.split("/");
        	return d[1]+"/"+d[0]+"/"+d[2];
        }
		
		vm.addSale = function(){
			
			if(!vm.newId || !vm.newName || !vm.newFromDate || !vm.newToDate || !vm.newDiscount){
				toastr.error("All fields (except categories) must be filled!");
				return ;
			}
			
			var articleCategories = [];
			Object.keys(vm.ac).forEach(function(key) {
			    value = vm.ac[key];
			    if(value)
					articleCategories.push(vm.temp[key])
			});
			
			data={"id":vm.newId, "name": vm.newName, "fromDate": new Date(vm.newFromDate), "toDate": new Date(vm.newToDate), 
					"discount": vm.newDiscount, "articleCategories":articleCategories}
			
			$http.post('/api/manager/addSale', data).then(function(response) {
				
				if(response.data){
					vm.sales = response.data;
					vm.newSale = false; vm.newId=''; vm.newName=''; vm.newDiscount=''; vm.newFromDate='';
					vm.newToDate=''; 
					
					Object.keys(vm.ac).forEach(function(key) {
					    vm.ac[key]=false;
					});
					
					toastr.success("Sale is successfully added!");
					
				}else{
					toastr.error("Already exist sale with entered ID!");
				}
			}, function(response) {
				toastr.error("Access Denied!");
			});	
		}
		
	}
    
})();