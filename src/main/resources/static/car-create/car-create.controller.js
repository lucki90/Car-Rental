angular.module('car-create')
    .controller('carCreateController', function (carService, $location, carClasses) {
        var vm = this;

        vm.car = {};

        vm.create = create;

        vm.carClasses = carClasses;
//Stworzy liste CarClass
//         carClassService.search().then(
//             function (responseCarClass) {
//                 vm.carClasses = responseCarClass;
//             }
//         );

        function create() {
            carService.create(vm.car)
                .then(function () {
                    $location.path('/cars');
                })
                .catch(function (response) {
                    vm.errors = response.data;
                });
        }

    });