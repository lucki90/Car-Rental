var carClassListModule = angular.module('carClass-list');

carClassListModule.controller('carClassListController', function (carClassService, $location) {
    var vm = this;

    vm.sortOption = [
        {
            displayName: 'Name ASC',
            value: 'name,asc'
        },
        {
            displayName: 'Name DESC',
            value: 'name,desc'
        },
        {
            displayName: 'Price ASC',
            value: 'price,asc'
        },
        {
            displayName: 'Price DESC',
            value: 'price,desc'
        }
    ];

    vm.params = {};

    vm.search = search;
    vm.remove = remove;
    vm.edit = edit;

    search();


    function search() {
        carClassService.search(vm.params)
            .then(function (response) {
                vm.carClasses = response;
            })
            .catch(function (response) {
                alert(response.data.message);
                vm.error = response.data.message;
            });
    }

    function remove(carClassId) {
        carClassService.remove(carClassId)
            .then(function () {
                search();
            });
    }

    function edit(id) {
        $location.path('/car-classes/edit/' + id);
    }
});