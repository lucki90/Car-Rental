angular.module('carClass-edit')
    .controller('carClassEditController', function(carClass, carClassService, $location) {
        var vm = this;

        vm.carClass = carClass;

        vm.update = update;

        function update() {
            carClassService.update(vm.carClass)
                .then(function() {
                    $location.path('/car-classes');
                })
                .catch(function(response) {
                    vm.errors = response.data;
                });
        }
    });