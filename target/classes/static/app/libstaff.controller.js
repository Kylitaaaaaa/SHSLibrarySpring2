(function(){
    'use strict:';
    angular
        .module('app', [])
        .factory('$exceptionHandler', ['$injector', function($injector) {
            return function(exception, cause) {
                window.location.href = '/dashboard';
            };
        }])
        .controller('LibStaffController', LibStaffController);



    LibStaffController.$inject = ['$scope','$http'];
    function LibStaffController($scope, $http) {
        var vm = this;
        vm.resources = [];
        vm.resourceRes = [];
        vm.mr = [];
        vm.currResource = null;
        vm.getAllResources = getAllResources;
        vm.removeResource = removeResource;
        vm.getCurrResource = getCurrResource;
        vm.getAllAvailMR = getAllAvailMR;

        $scope.formModel= {};
        $scope.onCreateRes = function(valid){
            if(valid){
                var url = "/libstaff/createResource";
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
            var url = "/libstaff/allResources";
            var adminsPromise = $http.get(url);
            adminsPromise.then(function(response){
                vm.resources = response.data;
                //vm.currResource = response.data;
            });
        }

        function getAllAvailMR() {
            var url = "/libstaff/allAvailMR";
            var adminsPromise = $http.get(url);
            adminsPromise.then(function (response) {
                vm.mr = response.data;
            });
        }

        function removeResource(resid) {
            var url = "/libstaff/removeResource/" + resid;
            $http.post(url).then(function (response) {
                vm.resources = response.data;
            }).then(function success(response) {
                console.log("success");
            }, function error(response) {
                console.log("fail");
            });
        }

        function getCurrResource(resid) {
            var url = "/libstaff/getCurrResource/" + resid;
            var adminsPromise = $http.get(url);
            adminsPromise.then(function (response) {
                vm.currResource = response.data;
                $scope.formModel = response.data;
            });
        }
    }
})();