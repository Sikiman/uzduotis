angular
    .module('ngCribs')
    .controller('cribsController', function ($scope, cribsFactory) {

        $scope.cribs;
        $scope.showDetails;
        $scope.newItem = {};


        $scope.populateList = function () {
            cribsFactory.getItems().then(function successCallback(response) {
                console.log(response);
                $scope.cribs = response.data;
            }, function errorCallback(response) {
                console.log(response);
            });
        }

        $scope.addItem = function (newItem) {
            console.log(newItem);
            cribsFactory.postItem(newItem);
            $scope.populateList();
        }


        $scope.deleteItem = function (IDToDelete) {
            let itemToDelete = {};
            itemToDelete.id = IDToDelete;
            cribsFactory.deleteItem(itemToDelete);
            $scope.populateList();
        }


        $scope.populateList();

    });
