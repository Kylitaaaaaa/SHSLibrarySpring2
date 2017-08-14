(function(){
    'use strict:';
    angular
        .module('app', [])
        // .factory('$exceptionHandler', ['$injector', function($injector) {
        //     return function(exception, cause) {
        //         window.location.href = '/dashboard';
        //     };
        // }])
        .controller('LogInController', LogInController);



    LogInController.$inject = ['$scope','$http', '$filter', '$rootScope', '$window'];
    function LogInController($scope, $http, $filter, $rootScope, $window) {
        var vm = this;
        vm.currUser = null;

        $scope.onAttempt2 = function(valid){
            var auth = null;
            var page = null;
            console.log("hereee");
            if(valid){
                var url = "/loginuser/specific/" + $scope.formModel.idnumber + "/" + $scope.formModel.password;
                console.log("url: " + url);
                $http.post(url, $scope.formModel).then(function(response){
                    console.log(response.data)
                    vm.currUser = response.data;
                    console.log(vm.currUser);
                    console.log("askldf");
                })
                    .then(function success(response) {
                        console.log("success");
                        if(vm.currUser.usertype == 0){
                            auth = 'Basic ' + btoa("admin:secret4");
                        page = "admin";
                        }
                        else if(vm.currUser.usertype == 1){
                            auth = 'Basic ' + btoa("libman:secret2");
                    page = "libman";}
                        else if(vm.currUser.usertype== 2){
                            auth = 'Basic ' + btoa("libstaff:secret3");
                        page="libstaff";}
                        else if(vm.currUser.usertype == 3){
                            auth = 'Basic ' + btoa("customer:secret1");
                        page = "customer";}

                        console.log("auth: " + auth);
                        // console.log(response);


                        $http({
                            method: 'POST',//or POST
                            url: 'http://localhost:8080/oauth/token',
                            data:"grant_type=password&username="+$scope.formModel.idnumber+"&password="+ $scope.formModel.password,
                            headers: {'Content-Type': 'application/x-www-form-urlencoded', 'Authorization': auth }
                        }).then(function successCallback(response) {
                            console.log("here 2 success");
                            console.log(response);
                            console.log("access token is: "+response.data["access_token"])
                            $rootScope.token = response.data["access_token"];
                            console.log("token: " + $rootScope.token);

                            var redirectUrl = "/"+page+"?access_token="+$rootScope.token;
                            console.log(redirectUrl);
                            $window.location.href =redirectUrl;


                        }, function errorCallback(response) {
                            console.log("here 2 fail");
                            console.log(response);
                            // called asynchronously if an error occurs
                            // or server returns response with an error status.
                        });
                    }, function error(response) {
                        console.log("fail");
                    });

            }
            else{
                console.log(":( not valid");
            }

/*
            if(vm.currUser != null){

                if(vm.currUser.usertype == 0)
                    auth = 'Basic ' + btoa("admin:secret1");
                else if(vm.currUser.usertype == 1)
                    auth = 'Basic ' + btoa("libman:secret1");
                else if(vm.currUser.usertype == 2)
                    auth = 'Basic ' + btoa("libstaff:secret1");
                else if(vm.currUser.usertype == 3)
                    auth = 'Basic ' + btoa("student:secret1");
                else if(vm.currUser.usertype == 4)
                    auth = 'Basic ' + btoa("professor:secret1");

            }
            console.log("auth: " + auth);


            $http({
                method: 'POST',//or POST
                url: 'http://localhost:8080/oauth/token',
                data:"grant_type=password&username=11429395&password=password",
                headers: {'Content-Type': 'application/x-www-form-urlencoded', 'Authorization': auth }
            }).then(function successCallback(response) {
                console.log("here 2 success");
                console.log(response);
                console.log("access token is: "+response.data["access_token"])
                // this callback will be called asynchronously
                // when the response is available
            }, function errorCallback(response) {
                console.log("here 2 fail");
                console.log(response);
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });
            */

        }


    }
})();