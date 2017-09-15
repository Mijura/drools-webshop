(function() {
	// controller bound to application body, parent controller to all others
	angular.module("myApp").controller('stockController', stockController);
	
	function stockController($scope, $http, toastr) {
		var vm = this;
		
		vm.view=false;
		
		$http.post('/api/salesman/fillingTheStock').then(function(response) {
			
			if(response.data){
				vm.articles = response.data;
				vm.por={};
				vm.view = true;
			}
		}, function(response) {
			toastr.error("Access Denied!");
		});	
		
		vm.pr = function(id){
			vm.id = id;
			vm.view2 = true;
		}
		
		vm.fill = function(id){
			var a = parseInt(vm.articles[vm.id].minCount);
			var b = parseInt(vm.articles[vm.id].count);
			var c = parseInt(vm.ch);
			if(c<(a-b)){
				toastr.error("You didnt enter enough articles");
				return;
			}
			
			var data =  { "newValue": (b+c), "article":vm.articles[vm.id] };
	        
			$http.post('/api/salesman/setNewValue', data).then(function(response) {
				
				vm.articles.splice(id, 1);
				toastr.success(" Article is filled");
				vm.view2=false;
				vm.ch=0;

			}, function(response) {
				toastr.error(response.data.response);
			});
			
		}
		
		vm.calcImage = function(id){
			return "images/articles/"+btoa(id)+".jpg"
		}
		
		vm.send = function(index){
			alert($scope.index);
			
		}
	}
    
})();