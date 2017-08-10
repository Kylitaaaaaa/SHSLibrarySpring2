(function(){
    'use strict:';
    angular
        .module('app', [])
        .factory('$exceptionHandler', ['$injector', function($injector) {
            return function(exception, cause) {
                window.location.href = '/dashboard';
            };
        }])
        .controller('LogInController', LogInController);



    LogInController.$inject = ['$scope','$http'];
    function LogInController($scope, $http) {
        var vm = this;
        vm.resp = false;
        vm.currAcct = null;
        var sample = null;


        $scope.formModel= {};
        $scope.onAttempt = function(valid){
            if(valid){
                 var url = "/logincontroller/attempt";
                 sample = $http.post(url, $scope.formModel);
                 console.log(sample);

                if(sample.idnumber==null)
                    console.log("NULL SAMPLE");

                console.log("done");
            }
            else{
                console.log(":( not valid");
            }


        }

        function getAcct(idnumber){
            var url = "/logincontroller/getAcct/" + idnumber;
            var adminsPromise = $http.get(url);
            adminsPromise.then(function(response){
                vm.currAcct = response.data;
                console.log(vm.currAcct);
            });
        }


        function isAcctExist(idnumber){
            var url = "/logincontroller/isExist/" + idnumber;
            var adminsPromise = $http.get(url);
            adminsPromise.then(function(response){
                vm.resp = response.data;

                if(vm.resp == true)
                        alert("Account exists");

                else
                    alert("Account does not exist");

            });
        }


    }
})();