angular.module('car')
    .service('carService', function ($resource, carSpecificationService) {
        var service = this;

        var carResource = $resource('http://localhost:8080/cars/:carId', {}, {
            // query: {
            //     method: 'GET',
            //     isArray: false
            // },
            update: {
                method: 'PUT'
            }
        });

        service.search = function (params) {
            return carResource.query(params).$promise;
        };

        service.create = function (car, addSpecification) {
            if (addSpecification) {
                return carSpecificationService.create(car.carSpecification)
                    .then(function (carSpecification) {
                        car.carSpecification = carSpecification;
                        return carResource.save({}, car).$promise;
                    });
            } else {
                return carResource.save({}, car).$promise;
            }
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
