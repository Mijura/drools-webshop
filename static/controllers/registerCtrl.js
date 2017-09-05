(function() {
	// controller bound to application body, parent controller to all others
	angular.module("myApp").controller('registerController', registerController);
	
	function registerController($scope, $timeout, toastr) {
		var vm = this;
		vm.image = "images/user.png";
		var reader = new FileReader();
		
		vm.register = function(){
			if(!vm.username || !vm.password || !vm.fname || !vm.lname || !vm.address || vm.image=="images/user.png"){
				toastr.error("Enter all fields!");
				return ;
			}
			
			var data = { 
				"username": vm.username, 
				"password": vm.password,
				"fname": vm.fname,
				"lname": vm.lanme,
				"address": vm.address,
				"image": vm.image
			};
	        
			$http.post('/api/users/register', data).then(function(response) {
				toastr.success("Succesfully registered!");
				$window.location = "#!/";

			}, function(response) {
				toastr.error(response.data.response);
			});
		}
		
		reader.onloadend = function (evt) {
        	$scope.$apply(function(){
        		vm.image = evt.target.result;
        	});
        };
		
		var handleFileSelect=function(evt) {
			file=evt.currentTarget.files[0];
	  	  	reader.readAsDataURL(file); 
	    };
	    
	    angular.element(document.querySelector('#fileInput')).on('change', handleFileSelect);
	    
	}
    
})();