﻿/* Login */
app.controller('validateLoginCtrl',['$scope','$location','$routeSegment', function($scope,$location,$routeSegment) {
	
  $scope.SubmitLogin = function() {

	if($scope.email=="admin@servinglynk.com" && $scope.password=="admin")
	{
		$location.path($routeSegment.getSegmentUrl('s2.dashboard')); 
	}
	else
	{
		alert("Invalid username & password");
	}

  };
}]);
