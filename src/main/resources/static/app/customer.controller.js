(function(){
    'use strict:';
    angular
        .module('app', ['toaster', 'ngAnimate'])
        // .factory('$exceptionHandler', ['$injector', function($injector) {
        //     return function(exception, cause) {
        //         window.location.href = '/dashboard';
        //     };
        // }])
        .controller('CustomerController', CustomerController);

    CustomerController.$inject = ['$scope','$http', '$filter'];
    function CustomerController($scope, $http, $filter) {
        init();
        var vm = this;
        vm.resources = [];
        vm.review = [];
        vm.availMR = [];
        vm.mr = [];
        vm.getAllResources = getAllResources;
        vm.allAvailMR = allAvailMR;
        vm.getCurrResource = getCurrResource;
        vm.viewCurrResource = viewCurrResource;
        vm.reserveResource = reserveResource;
        vm.reserveMR = reserveMR;
        vm.currResource = null;
        vm.canreview = null;

        $scope.formModel= {};

        $scope.onSearchResources = function(valid){
            if(valid){
                var url = "/customer/onSearchResources/"+ $scope.formModel.restype + "/" + $scope.formModel.options + "/" +$scope.formModel.searchitem;
                console.log(url);
                $http.get(url).then(function (response) {
                    vm.resources = response.data;
                });
            }
            else{
                console.log(":( not valid");
            }
        }

        $scope.onChangePass = function(valid){
            if(valid){
                var idnumber = 11429395;
                var url = "/customer/onChangePass/"+ $scope.formModel.oldpassword + "/" + $scope.formModel.password + "/" + $scope.formModel.confirmpassword + "/" + idnumber;
                console.log(url);
                $http.post(url).then(function (response) {
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
                var url = "/customer/onSearchMR/"+ $scope.formModel.starttime + "/" + usagedateformat;
                $http.get(url).then(function (response) {
                    vm.availMR = response.data;
                });
            }
            else{
                console.log(":( not valid");
            }
        }

        $scope.onReview = function(valid){
            if(valid){
                var currdate = $filter("date")(Date.now(), 'yyyy-MM-dd');
                console.log(currdate);
                var userid = 1;
                var url = "/customer/onReview/"+ $scope.formModel.reviewcontent + "/" + vm.currResource.bookid + "/" + userid + "/" + currdate;
                $http.post(url, $scope.formModel).then(function (response) {
                    vm.review = response.data;
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
                $http.post(url, $scope.formModel).then(function (response) {
                    vm.review = response.data;
                });
            }
            else{
                console.log(":( not valid");
            }

        }


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

        function reserveResource(bookid) {
            var reservationdate = $filter("date")(Date.now(), 'yyyy-MM-dd');


            var today = new Date();

            var returndate = new Date(today);

            returndate.setDate(today.getDate()+7);

            returndate = $filter("date")(returndate, 'yyyy-MM-dd');



            var status = 1;
            var userid = 1;

            var url = "/customer/reserveResource/" + bookid + "/" + reservationdate  + "/" + returndate + "/"  + status + "/" + userid + "/" + $scope.formModel.restype + "/" + $scope.formModel.options + "/" +$scope.formModel.searchitem;

            if($scope.formModel.restype == null){
                url = "/customer/reserveResourceAll/" + bookid + "/" + reservationdate  + "/" + returndate + "/"  + status + "/" + userid;
            }

            $http.post(url).then(function (response) {
                vm.resources = response.data;
            });
        }

        function reserveMR(meetingroomid, usagedate, starttime) {
            var usagedateformat = $filter("date")(usagedate, 'yyyy-MM-dd');

            var reservationdate = $filter("date")(Date.now(), 'yyyy-MM-dd');
            var userid = 1;

            var url = "/customer/reserveMR/" + meetingroomid + "/" + userid  + "/" + reservationdate + "/"  + usagedateformat + "/" + starttime;
            $http.post(url).then(function (response) {
                vm.availMR = response.data;
            });

            console.log(vm.availMR);
        }

        function allAvailMR(searchdate) {
            var url = "/customer/allAvailMR/" + searchdate;
            var adminsPromise = $http.get(url);
            $http.get(url).then(function (response) {
                vm.mr = response.data;
            });
        }

        function getCurrResource(bookid) {
            var url = "/customer/getCurrResource/" + bookid;
            var adminsPromise = $http.get(url);
            adminsPromise.then(function(response){
                vm.currResource = response.data;
            });
        }
        function viewCurrResource(bookid) {
            var url = "/customer/getCurrResource/" + bookid;
            var adminsPromise = $http.get(url);
            adminsPromise.then(function(response){
                vm.currResource = response.data;
            });

            url = "/customer/getReviewCurrResource/" + bookid;
            $http.get(url).then(function(response){
                vm.review = response.data;
            });

            var userid = 1;
            url = "/customer/canReview/" + bookid + "/" + userid;
            $http.get(url).then(function(response){
                vm.canreview = response.data;
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