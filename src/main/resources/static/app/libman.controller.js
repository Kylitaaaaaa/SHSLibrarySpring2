(function(){
    'use strict:';
    angular
        .module('app', [])
        .controller('LibManController', LibManController);



    LibManController.$inject = ['$scope','$http'];
    function LibManController($scope, $http) {
        var vm = this;
        vm.resources = [];
        vm.resourceRes = [];
        vm.mrRes = [];
        vm.currResource = null;
        vm.getAllResources = getAllResources;
        vm.getAllResourcesRes = getAllResourcesRes;
        vm.getAllMRRes = getAllMRRes;
        vm.removeResource = removeResource;
        vm.removeResourceRes = removeResourceRes;
        vm.removeResourceMRRes = removeResourceMRRes;
        vm.getCurrResource = getCurrResource;
        vm.getCurrResourceRes = getCurrResourceRes;
        vm.getCurrRoomRes = getCurrRoomRes;

        $scope.formModel= {};
        $scope.onCreateRes = function(valid){
            if(valid){
                var url = "/libman/createResource";
                $http.post(url, $scope.formModel)
                    .then(function success(response) {
                        console.log("success");
                    }, function error(response) {
                        console.log("fail");
                    });
            }
            else{
                console.log(":( not valid");
            }
        }

        $scope.onSaveResourceRes = function(valid){
            if(valid){
                var url = "/libman/saveResourceRes";
                $http.post(url, $scope.formModel)
                    .then(function success(response) {
                        console.log("success");
                    }, function error(response) {
                        console.log("fail");
                    });
            }
            else{
                console.log(":( not valid");
            }
        }

        $scope.onSaveRoomRes = function(valid){
            if(valid){
                var url = "/libman/saveRoomRes";
                $http.post(url, $scope.formModel)
                    .then(function success(response) {
                        console.log("success");
                    }, function error(response) {
                        console.log("fail");
                    });
            }
            else{
                console.log(":( not valid");
            }
        }



        init();
        function init() {
            getAllResources();
        }

        function getAllResources() {
            var url = "/libman/allResources";
            var adminsPromise = $http.get(url);
            adminsPromise.then(function(response){
                vm.resources = response.data;
                //vm.currResource = response.data;
            });
        }

        function getAllResourcesRes() {
            var url = "/libman/allResourcesRes";
            var adminsPromise = $http.get(url);
            adminsPromise.then(function(response){
                vm.resourceRes = response.data;
            });
        }

        function getAllMRRes() {
            var url = "/libman/allMRRes";
            var adminsPromise = $http.get(url);
            adminsPromise.then(function(response){
                vm.mrRes = response.data;
            });
        }

        function removeResource(resid) {
            var url = "/libman/removeResource/" + resid;
            $http.post(url).then(function (response) {
                vm.resources = response.data;
            }).then(function success(response) {
                console.log("success");
            }, function error(response) {
                console.log("fail");
            });
        }

        function removeResourceRes(resid) {
            var url = "/libman/removeResourceRes/" + resid;
            $http.post(url).then(function (response) {
                vm.resourceRes = response.data;
            }).then(function success(response) {
                console.log("success");
            }, function error(response) {
                console.log("fail");
            });
        }

        function removeResourceMRRes(resid) {
            var url = "/libman/removeResourceMRRes/" + resid;
            $http.post(url).then(function (response) {
                vm.mrRes = response.data;
            }).then(function success(response) {
                console.log("success");
            }, function error(response) {
                console.log("fail");
            });
        }

        function getCurrResource(resid) {
            var url = "/libman/getCurrResource/" + resid;
            var adminsPromise = $http.get(url);
            adminsPromise.then(function (response) {
                vm.currResource = response.data;
                $scope.formModel = response.data;
            });
        }

        function getCurrResourceRes(resid) {
            var url = "/libman/getCurrResourceRes/" + resid;
            var adminsPromise = $http.get(url);
            adminsPromise.then(function (response) {
                $scope.formModel = response.data;
            });
        }

        function getCurrRoomRes(resid) {
            var url = "/libman/getCurrRoomRes/" + resid;
            var adminsPromise = $http.get(url);
            adminsPromise.then(function (response) {
                $scope.formModel = response.data;
            });
        }


    }
})();