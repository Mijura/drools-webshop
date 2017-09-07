angular.module('myApp',
		[ 'ngResource', 'ngRoute','ngCookies', 'toastr','moment-picker'])
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
				templateUrl : 'views/home.html',
				controller : "homeController",
				controllerAs : "homeCtrl"
			})
			.when('/customerCategories', {
				templateUrl : 'views/customerCategories.html',
				controller : "customerCategoriesController",
				controllerAs : "customerCategoriesCtrl"
			})
			.when('/articleCategories', {
				templateUrl : 'views/articleCategories.html',
				controller : "articleCategoriesController",
				controllerAs : "articleCategoriesCtrl"
			})
			.when('/sale', {
				templateUrl : 'views/sale.html',
				controller : "saleController",
				controllerAs : "saleCtrl"
			})
			.when('/cart', {
				templateUrl : 'views/cart.html',
				controller : "cartController",
				controllerAs : "cartCtrl"
			})
			.otherwise({
				redirectTo : '/'
			});
		} ]);
