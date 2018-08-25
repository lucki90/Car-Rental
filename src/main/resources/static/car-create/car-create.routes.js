angular.module('car-create')
.config(function ($routeProvider) {
    $routeProvider.when('/cars/add/',{
        templateUrl: '/car-create/car-create.html',
        controller: 'carCreateController',
        controllerAs: 'vm',
        resolve: {
            carClasses: function (carClassService) {
                return carClassService.search();
            }
        }
    });
});