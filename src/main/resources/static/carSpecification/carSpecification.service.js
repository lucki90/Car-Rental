angular.module('carSpecification')
    .service('carSpecificationService', function ($resource) {
        var service = this;

        var carSpecificationResource = $resource('http://localhost:8080/car-specifications/:carSpecificationId', {}, {
            // query: {
            //     method: 'GET',
            //     isArray: false
            // },
            update: {
                method: 'PUT'
            }
        });

        service.search = function (params) {
            return carSpecificationResource.query(params).$promise;
        };

        service.create = function (carSpecification) {
            return carSpecificationResource.save({}, carSpecification).$promise;
        };

        service.remove = function (id) {
            return carSpecificationResource.remove({
                carSpecificationId: id
            }).$promise;
        };
        service.get = function(id) {
            return carSpecificationResource.get({
                carSpecificationId: id
            }).$promise;
        };

        service.update = function(carSpecification) {
            return carSpecificationResource.update({
                carSpecificationId: carSpecification.id
            }, carSpecification).$promise;
        };
    });
