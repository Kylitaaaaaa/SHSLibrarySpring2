(function(){
    'use strict:';
    angular
        .module('app', ['toaster', 'ngAnimate'])

        // .factory('$exceptionHandler', ['$injector', function($injector) {
        //     return function(exception, cause) {
        //         window.location.href = '/dashboard';
        //     };
        // }])
        .controller('GenController', GenController);

    GenController.$inject = ['$scope','$http'];
    function GenController($scope, $http) {

        var vm = this;
        vm.users = [];
        vm.getAll = getAll;
        vm.getAllMan = getAllMan;
        vm.getAllStaff = getAllStaff;
        vm.getAllProf = getAllProf;
        vm.getAllStudent = getAllStudent;
        vm.create = create;
        vm.unlockUser = unlockUser;
        vm.currPrev = null;

        $scope.formModel= {};
        $scope.onSubmit = function(valid){
            if(valid){
                var url = "/gen/create";
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
            getAllMan();
            vm.currPrev = 1;
        }

        function getAll() {
            var url = "/gen/allAdmin";
            var adminsPromise = $http.get(url);
            vm.currPrev = 0;
            adminsPromise.then(function(response){
                vm.users = response.data;
            });
        }

        /*USER TYPE
         * 0 - Admin
         * 1 - Manager
         * 2 - Staff
         * 3 - Prof
         * 4 - Student
         */

        function getAllMan() {
            var url = "/gen/type/" + 1;
            vm.currPrev = 1;
            var adminsPromise = $http.get( url);
            adminsPromise.then(function(response){
                vm.users = response.data;
            });
        }

        function getAllStaff() {
            var url = "/gen/type/" + 2;
            vm.currPrev = 2;
            var adminsPromise = $http.get( url);
            adminsPromise.then(function(response){
                vm.users = response.data;
            });
        }

        function getAllProf() {
            var url = "/gen/type/" + 3;
            vm.currPrev = 3;
            var adminsPromise = $http.get( url);
            adminsPromise.then(function(response){
                vm.users = response.data;
            });
        }

        function getAllStudent() {
            var url = "/gen/type/" + 4;
            vm.currPrev = 4;
            var adminsPromise = $http.get( url);
            adminsPromise.then(function(response){
                vm.users = response.data;
            });
        }

        function unlockUser(resid) {
            var url = "/gen/unlockUser/" + resid + "/" + vm.currPrev;
            $http.post(url).then(function (response) {
                vm.users = response.data;
            });
        }




        function create(){
            var url = "/gen/create";

            /*
             var user = {
             idnumber:2,
             password:"pass",
             emailaddress:"email",
             lockstatus : 0,
             phonenumber : "p1",
             loginattempts : 0,
             firstname : "f1",
             lastname : "l1",
             middleinitial : "m1",
             birthday : "b1",
             secretquestion : "q1",
             secretanswer : "a1"
             };
             */

            alert('user creating :)');
            var passwordHash = require('password-hash');

            var hashedPassword = passwordHash.generate('password123');


            $http.post(url, user).then(function(response){
                alert('user saved :)');
            });
        }
    }
})();