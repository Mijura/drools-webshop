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
			vm.edit.fromDate = moment(vm.edit.fromDate).format('MM-DD-YYYY');
			vm.edit.toDate = moment(vm.edit.toDate).format('MM-DD-YYYY');
			
			Object.keys(vm.ac).forEach(function(key) {
			    vm.ac[key]=false;
			});
			
			vm.edit.articleCategories.forEach(function(y){
				vm.ac[y.id]=true;
			
			});
				
			
		}
		
		vm.formatDate = function(date){
	          var dateOut = new Date(date);
	          return dateOut;
	    };
	    
		vm.editSale = function(){
			
			if(!vm.edit.id || !vm.edit.name || !vm.edit.fromDate || !vm.edit.toDate || !vm.edit.discount){
				toastr.error("All fields (except categories) must be filled!");
				return ;
			}
			
			var articleCategories = [];
			Object.keys(vm.ac).forEach(function(key) {
			    value = vm.ac[key];
			    if(value)
					articleCategories.push(vm.temp[key])
			});
			
			data={"id":vm.edit.id, "name": vm.edit.name, "fromDate": new Date(vm.edit.fromDate), 
					"toDate": new Date(vm.edit.toDate), 
					"discount": vm.edit.discount, "articleCategories":articleCategories}
			
			$http.post('/api/manager/editSale', data).then(function(response) {
				
				if(response.data){
					vm.edit = null;
					vm.sales = response.data; 
					
					Object.keys(vm.ac).forEach(function(key) {
					    vm.ac[key]=false;
					});
					
					toastr.success("Sale is successfully changed!");
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