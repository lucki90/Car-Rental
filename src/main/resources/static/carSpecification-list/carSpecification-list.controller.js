var carSpecificationListModule = angular.module('carSpecification-list');

carSpecificationListModule.controller('carSpecificationListController', function (carSpecificationService, $location) {
    var vm = this;

    vm.params = {};

    vm.search = search;
    vm.remove = remove;
    vm.edit = edit;

    search();


    function search() {
        carSpecificationService.search(vm.params)
            .then(function (response) {
                vm.carSpecification = response;
            })
            .catch(function (response) {
                alert(response.data.message);
                vm.error = response.data.message;
            });
    }

    function remove(carSpecificationId) {
        carSpecificationService.remove(carSpecificationId)
            .then(function () {
                search();
            });
    }

    function edit(id) {
        $location.path('/car-specifications/edit/' + id);
    }
});