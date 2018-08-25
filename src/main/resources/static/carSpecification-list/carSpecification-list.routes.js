var carSpecificationListModule = angular.module('carSpecification-list');

carSpecificationListModule.config(function ($routeProvider) {
    $routeProvider.when('/car-specifications', {
        templateUrl: '/carSpecification-list/carSpecification-list.html',
        controller: 'carSpecificationListController',
        controllerAs: 'vm'
    });
});