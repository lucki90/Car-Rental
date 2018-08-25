angular.module('carClass-edit')
    .config(function($routeProvider) {
        $routeProvider.when('/car-classes/edit/:carClassId', {
            templateUrl: '/carClass-edit/carClass-edit.html',
            controller: 'carClassEditController',
            controllerAs: 'vm',
            resolve: {
                car: function(carClassService, $route) {
                    return carClassService.get($route.current.params.carClassId);
                }
            }
        });
    });