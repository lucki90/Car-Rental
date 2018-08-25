angular.module('carSpecification-edit')
    .controller('carSpecificationEditController', function(carSpecification, carSpecificationService, $location) {
        var vm = this;

        vm.carSpecification = carSpecification;

        vm.update = update;

        function update() {
            carSpecificationService.update(vm.carSpecification)
                .then(function() {
                    $location.path('/car-specifications');
                })
                .catch(function(response) {
                    vm.errors = response.data;
                });
        }
    });