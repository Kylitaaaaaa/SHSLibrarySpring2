(function(){
    'use strict:';
    angular
        .module('app', ['toaster', 'ngAnimate'])
        .controller('CustomerController', CustomerController);

    CustomerController.$inject = ['$scope','$http'];
    function CustomerController($scope, $http) {
        var vm = this;
        vm.resources = [];
        vm.mr = [];

        $scope.formModel= {};
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
            $http.post(url).then(function (response) {
                vm.mr = response.data;
            });
        }

    }
})();