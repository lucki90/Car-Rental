var carListModule = angular.module('car-list');

carListModule.config(function ($routeProvider) {
    $routeProvider.when('/cars', {
        templateUrl: '/car-list/car-list.html',
        controller: 'carListController',
        controllerAs: 'vm'
    });
});