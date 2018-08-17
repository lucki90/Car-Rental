angular.module('car-edit')
    .config(function($routeProvider) {
        $routeProvider.when('/cars/edit/:carId', {
            templateUrl: '/car-edit/car-edit.html',
            controller: 'carEditController',
            controllerAs: 'vm',
            resolve: {
                car: function(carService, $route) {
                    return carService.get($route.current.params.carId);
                }
            }
        });
    });