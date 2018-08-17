angular.module('car-edit')
    .controller('carEditController', function(car, carService, $location) {
        var vm = this;

        vm.car = car;

        vm.update = update;

        function update() {
            carService.update(vm.car)
                .then(function() {
                    $location.path('/cars');
                })
                .catch(function(response) {
                    vm.errors = response.data;
                });
        }
    });