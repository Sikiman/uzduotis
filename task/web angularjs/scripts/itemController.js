angular
    .module('itemApp')
    .controller('itemController', function ($scope, itemFactory) {

        $scope.items;
        $scope.newItem = {
            "id": 0,
            "price": 0,
            "details": ""
        };


        $scope.populateList = function () {
            itemFactory.getItems().then(function successCallback(response) {
                console.log(response);
                $scope.items = response.data;
            }, function errorCallback(response) {
                console.log(response);
            });
        }
        
        $scope.populateList();


        $scope.addItem = function (newItem) {
            console.log(newItem);
            itemFactory.postItem(newItem);
            setTimeout(() => {$scope.populateList()}, 400);
        }


        $scope.deleteItem = function (itemToDelete) {
            delete itemToDelete.$$hashKey;
            itemFactory.deleteItem(itemToDelete);
            setTimeout(() => {$scope.populateList()}, 400);
        }
    });
