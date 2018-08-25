angular.module('carSpecification-edit')
    .config(function($routeProvider) {
        $routeProvider.when('/car-specifications/edit/:carClassId', {
            templateUrl: '/carSpecification-edit/carSpecification-edit.html',
            controller: 'carSpecificationEditController',
            controllerAs: 'vm'
        });
    });