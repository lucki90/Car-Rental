angular.module('carClass-create')
    .controller('carClassCreateController', function (carClassService, $location) {
        var vm = this;

        vm.carClass = {};

        vm.create = create;

        function create() {
            carService.create(vm.carClass)
                .then(function () {
                    $location.path('/car-classes');
                })
                .catch(function (response) {
                    vm.errors = response.data;
                });
        }

    });