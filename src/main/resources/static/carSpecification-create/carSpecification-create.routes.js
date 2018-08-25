angular.module('carSpecification-create')
    .config(function ($routeProvider) {
        $routeProvider.when('/car-specifications/add',{
            templateUrl: '/carSpecification-create/carSpecification-create.html',
            controller: 'carSpecificationCreateController',
            controllerAs: 'vm'
        });
    });