angular.module('carSpecification-create')
    .controller('carSpecificationCreateController', function (carSpecificationService, $location) {
        var vm = this;

        vm.carSpecification = {};

        vm.create = create;

        function create() {
            carSpecification.create(vm.carSpecification)
                .then(function () {
                    $location.path('/car-specification');
                })
                .catch(function (response) {
                    vm.errors = response.data;
                });
        }

    });