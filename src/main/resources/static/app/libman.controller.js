(function(){
    'use strict:';
    angular
        .module('app', [])
        // .factory('$exceptionHandler', ['$injector', function($injector) {
        //     return function(exception, cause) {
        //         window.location.href = '/dashboard';
        //     };
        // }])
        .controller('LibManController', LibManController);



    LibManController.$inject = ['$scope','$http', '$filter'];
    function LibManController($scope, $http, $filter) {
        init();
        var vm = this;
        vm.resources = [];
        vm.resourceRes = [];
        vm.mrRes = [];
        vm.currResource = null;
        vm.currResourceRes = null;
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
                console.log(url);
                $http.post(url, $scope.formModel).then(function (response) {
                    vm.resources = response.data;
                });
            }
            else{
                console.log(":( not valid");
            }
        }

        $scope.onSearchMR = function(valid){
            if(valid){
                var usagedateformat = $filter("date")($scope.formModel.usagedate, 'yyyy-MM-dd');
                console.log(usagedateformat);
                var url = "/libstaff/onSearchMR/"+ $scope.formModel.starttime + "/" + usagedateformat;
                $http.get(url).then(function (response) {
                    vm.availMR = response.data;
                });
            }
            else{
                console.log(":( not valid");
            }
        }

        $scope.onSaveResourceRes = function(valid){
            if(valid){
                var url = "/libman/saveResourceRes";
                $scope.formModel.resid = vm.currResourceRes.resid;

                $http.post(url, $scope.formModel).then(function (response) {
                    vm.resourceRes = response.data;
                });
            }
            else{
                console.log(":( not valid");
            }
        }

        $scope.onSaveRoomRes = function(valid){
            if(valid){
                var url = "/libman/saveRoomRes";
                var temp = $filter("date")($scope.formModel.usagedate, 'yyyy-MM-dd');
                $scope.formModel.usagedate = temp;
                $http.post(url, $scope.formModel).then(function (response) {
                    vm.mrRes = response.data;
                });
            }
            else{
                console.log(":( not valid");
            }
        }






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
                vm.currResourceRes = response.data;
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