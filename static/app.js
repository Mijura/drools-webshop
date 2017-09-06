angular.module('myApp',
		[ 'ngResource', 'ngRoute','ngCookies', 'toastr'])
		.config([ '$routeProvider', function($routeProvider) {
			$routeProvider
			.when('/', {
				templateUrl : 'views/login.html',
				controller : "loginController",
				controllerAs : "loginCtrl"
			})
			.when('/register', {
				templateUrl : 'views/register.html',
				controller : "registerController",
				controllerAs : "registerCtrl"	
			})
			.when('/home', {
				templateUrl : 'views/home.html'
			})
			.when('/customerCategories', {
				templateUrl : 'views/customerCategories.html',
				controller : "customerCategoriesController",
				controllerAs : "customerCategoriesCtrl"
			})
			.otherwise({
				redirectTo : '/'
			});
		} ]);
