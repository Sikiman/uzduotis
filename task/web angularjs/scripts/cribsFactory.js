angular
    .module('ngCribs')
    .factory('cribsFactory', function ($http) {

        function getItems() {
            return $http({
                method: 'GET',
                url: 'http://localhost:8080/items'
            });
        }

        function postItem(newItem) {
            $http({
                url: 'http://localhost:8080/additem',
                method: "POST",
                data: newItem
            }).then(function (response) {
                console.log(response);
            },
                function (response) {
                    console.log(response);
                });
        }

        function deleteItem(itemToDelete) {
            $http({
                url: 'http://localhost:8080/deleteitem',
                method: "DELETE",
                headers: {
                    'Content-type': 'application/json;charset=utf-8'
                },
                data: itemToDelete
            }).then(function (response) {
                console.log(response);
            },
                function (response) {
                    console.log(response);
                });
        }

        return {
            getItems: getItems,
            postItem: postItem,
            deleteItem: deleteItem
        }
    });