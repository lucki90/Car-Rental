angular.module('carClass-create')
.config(function ($routeProvider) {
    $routeProvider.when('/car-classes/add',{
        templateUrl: '/carClass-create/carClass-create.html',
        controller: 'carClassCreateController',
        controllerAs: 'vm'
    });
});