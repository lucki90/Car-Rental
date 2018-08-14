angular.module('car')
    .service('carService', function ($resource) {
        var service = this;

        var carResource = $resource('http://localhost:8080/cars/:carId', {}, {
            query: {
                method: 'GET',
                isArray: false
            },
            update: {
                method: 'PUT'
            }
        });

        service.search = function (params) {
            return carResource.query(params).$promise;
        };

        service.create = function (car) {
            return carResource.save({}, car).$promise;
        };

        service.remove = function (id) {
            return carResource.remove({
                carId: id
            }).$promise;
        };
        service.get = function(id) {
            return carResource.get({
                carId: id
            }).$promise;
        };

        service.update = function(car) {
            return carResource.update({
                carId: car.id
            }, car).$promise;
        };
    });
