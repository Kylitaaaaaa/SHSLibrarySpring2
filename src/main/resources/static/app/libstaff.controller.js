(function(){
    'use strict:';
    angular
        .module('app', [])
        // .factory('$exceptionHandler', ['$injector', function($injector) {
        //     return function(exception, cause) {
        //         window.location.href = '/dashboard';
        //     };
        // }])
        .controller('LibStaffController', LibStaffController);



    LibStaffController.$inject = ['$scope','$http', '$filter', '$rootScope'];
    function LibStaffController($scope, $http, $filter) {
        init();
        var vm = this;
        vm.resources = [];
        vm.resourceRes = [];
        vm.availMR = [];
        vm.currResource = null;
        vm.getAllResources = getAllResources;
        vm.removeResource = removeResource;
        vm.getCurrResource = getCurrResource;
        vm.getAllAvailMR = getAllAvailMR;

        $scope.formModel= {};
        $scope.onCreateRes = function(valid){
            if(valid){
                var url = "/libstaff/createResource";
                //$http.post(url, $scope.formModel).then(function (response) {
                //    vm.resources = response.data;
                //});

                $http({
                    method: 'POST',//or POST
                    url: url,
                    data: $scope.formModel,
                    headers: {'Accept': 'application/json', 'Authorization': 'Bearer '+$rootScope.token,}
                }).then(function successCallback(response) {
                    console.log("here 2 success");
                    console.log(response);
                    vm.resources = response.data;

                }, function errorCallback(response) {
                    console.log("here 2 fail");
                    console.log(response);
                    // called asynchronously if an error occurs
                    // or server returns response with an error status.
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