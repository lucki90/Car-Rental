var carClassListModule = angular.module('carClass-list');

carClassListModule.config(function ($routeProvider) {
    $routeProvider.when('/car-classes', {
        templateUrl: '/carClass-list/carClass-list.html',
        controller: 'carClassListController',
        controllerAs: 'vm'
    });
});