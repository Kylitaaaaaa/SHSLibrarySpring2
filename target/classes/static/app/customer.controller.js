(function(){
    'use strict:';
    angular
        .module('app', ['toaster', 'ngAnimate'])
        .factory('$exceptionHandler', ['$injector', function($injector) {
            return function(exception, cause) {
                window.location.href = '/dashboard';
            };
        }])
        .controller('CustomerController', CustomerController);

    CustomerController.$inject = ['$scope','$http'];
    function CustomerController($scope, $http) {
        var vm = this;
        vm.resources = [];
        vm.mr = [];
        vm.getAllResources = getAllResources;
        vm.allAvailMR = allAvailMR;
        vm.getCurrResource = getCurrResource;
        vm.currResource = null;

        $scope.formModel= {};

        $scope.onSearchResources = function(valid){
            if(valid){
                var url = "/customer/onSearchResources/"+ $scope.formModel.restype + "/" + $scope.formModel.options + "/" +$scope.formModel.searchitem;
                var adminsPromise = $http.get(url);
                $http.get(url).then(function (response) {
                    vm.resources = response.data;
                });
            }
            else{
                console.log(":( not valid");
            }
        }


        $scope.reserveResourceRes = function(valid){
            if(valid){
                var url = "/customer/reserveResourceRes";
                $scope.formModel.redate = $filter("date")(Date.now(), 'yyyy-MM-dd');
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

        $scope.saveReview = function(valid){
            if(valid){
                var url = "/customer/saveReview";
                $scope.formModel.reviewdate = $filter("date")(Date.now(), 'yyyy-MM-dd');
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

        $scope.reserveMRRes = function(valid){
            if(valid){
                var url = "/customer/reserveMRRes";
                $scope.formModel.resdate = $filter("date")(Date.now(), 'yyyy-MM-dd');
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

        function init(){
            getAllResources();
        }

        function searchByAuthor(author) {
            var url = "/customer/searchByAuthor/" + author;
            var adminsPromise = $http.get(url);
            $http.post(url).then(function (response) {
                vm.resources = response.data;
            });
        }

        function searchByTitle(title) {
            var url = "/customer/searchByTitle/" + title;
            var adminsPromise = $http.get(url);
            $http.post(url).then(function (response) {
                vm.resources = response.data;
            });
        }

        function searchByPublisher(publisher) {
            var url = "/customer/searchByPublisher/" + publisher;
            var adminsPromise = $http.get(url);
            $http.post(url).then(function (response) {
                vm.resources = response.data;
            });
        }

        function allAvailMR() {
            var url = "/customer/allAvailMR";
            var adminsPromise = $http.get(url);
            $http.get(url).then(function (response) {
                vm.mr = response.data;
            });
        }


        function getCurrResource(resid) {
            var url = "/customer/getCurrResource/" + resid;
            var adminsPromise = $http.get(url);
            adminsPromise.then(function(response){
                vm.currResource = response.data;
            });
        }

        function getAllResources() {
            var url = "/customer/getAllResources";
            var adminsPromise = $http.get(url);
            adminsPromise.then(function(response){
                vm.resources = response.data;
            });
        }

    }
})();