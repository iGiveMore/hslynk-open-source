

app.controller('bulkUploadCtrl', function ($scope, $location, $routeSegment, $http, $timeout) {

    $scope.submitForm = function () {

        $scope.infoTextAlert = "Please wait uploading....";
        $scope.showInfoAlert = true;

        Service.bulkupload($http, $scope,
 //success
            function () {
                $scope.switchBool("showInfoAlert");
                $scope.successTextAlert = "File has been uploaded successfully.";
                $scope.showSuccessAlert = true;
				$location.path("/admin/managesync");
            },
//error
       function () {
			   $location.path("/admin/managesync");
          // $scope.switchBool("showInfoAlert");
           //$scope.errorTextAlert = "Error, Something gone wrong.";
          // $scope.showErrorAlert = true;
           
       })

      
        return false;
    }

    // switch flag
    $scope.switchBool = function (value) {
        $scope[value] = !$scope[value];
    };

});

