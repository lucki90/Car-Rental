angular.module('carClass')
    .service('carClassService', function ($resource) {
        var service = this;

        var carClassResource = $resource('http://localhost:8080/car-classes/:carClassId', {}, {
            // query: {
            //     method: 'GET',
            //     isArray: false
            // },
            update: {
                method: 'PUT'
            }
        });

        service.search = function (params) {
            return carClassResource.query(params).$promise;
        };

        service.create = function (carClass) {
            return carClassResource.save({}, carClass).$promise;
        };

        service.remove = function (id) {
            return carClassResource.remove({
                carClassId: id
            }).$promise;
        };
        service.get = function(id) {
            return carClassResource.get({
                carClassId: id
            }).$promise;
        };

        service.update = function(carClass) {
            return carClassResource.update({
                carClassId: carClass.id
            }, carClass).$promise;
        };
    });
