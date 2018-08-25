angular.module('car-create')
    .controller('carCreateController', function (carService, $location, carClasses) {
        var vm = this;

        vm.car = {};

        vm.carSpecification = {};

        vm.create = create;

        vm.carClasses = carClasses;
//Stworzy liste CarClass
//         carClassService.search().then(
//             function (responseCarClass) {
//                 vm.carClasses = responseCarClass;
//             }
//         );

        function create() {
            vm.car.carSpecification = vm.carSpecification;
            carService.create(vm.car, true)
                .then(function () {
                    $location.path('/cars');
                })
                .catch(function (response) {
                    vm.errors = response.data;
                });
        }

    });