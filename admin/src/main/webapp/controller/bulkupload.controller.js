

app.controller('bulkUploadCtrl',[ '$scope', '$location', '$routeSegment', '$http', '$timeout','$sessionStorage', function ($scope, $location, $routeSegment, $http, $timeout,$sessionStorage){
	$scope.sessionToken = $sessionStorage.sessionToken;
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	var Base64={_keyStr:"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",encode:function(e){var t="";var n,r,i,s,o,u,a;var f=0;e=Base64._utf8_encode(e);while(f<e.length){n=e.charCodeAt(f++);r=e.charCodeAt(f++);i=e.charCodeAt(f++);s=n>>2;o=(n&3)<<4|r>>4;u=(r&15)<<2|i>>6;a=i&63;if(isNaN(r)){u=a=64}else if(isNaN(i)){a=64}t=t+this._keyStr.charAt(s)+this._keyStr.charAt(o)+this._keyStr.charAt(u)+this._keyStr.charAt(a)}return t},decode:function(e){var t="";var n,r,i;var s,o,u,a;var f=0;e=e.replace(/[^A-Za-z0-9+/=]/g,"");while(f<e.length){s=this._keyStr.indexOf(e.charAt(f++));o=this._keyStr.indexOf(e.charAt(f++));u=this._keyStr.indexOf(e.charAt(f++));a=this._keyStr.indexOf(e.charAt(f++));n=s<<2|o>>4;r=(o&15)<<4|u>>2;i=(u&3)<<6|a;t=t+String.fromCharCode(n);if(u!=64){t=t+String.fromCharCode(r)}if(a!=64){t=t+String.fromCharCode(i)}}t=Base64._utf8_decode(t);return t},_utf8_encode:function(e){e=e.replace(/rn/g,"n");var t="";for(var n=0;n<e.length;n++){var r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r)}else if(r>127&&r<2048){t+=String.fromCharCode(r>>6|192);t+=String.fromCharCode(r&63|128)}else{t+=String.fromCharCode(r>>12|224);t+=String.fromCharCode(r>>6&63|128);t+=String.fromCharCode(r&63|128)}}return t},_utf8_decode:function(e){var t="";var n=0;var r=c1=c2=0;while(n<e.length){r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r);n++}else if(r>191&&r<224){c2=e.charCodeAt(n+1);t+=String.fromCharCode((r&31)<<6|c2&63);n+=2}else{c2=e.charCodeAt(n+1);c3=e.charCodeAt(n+2);t+=String.fromCharCode((r&15)<<12|(c2&63)<<6|c3&63);n+=3}}return t}}
	// Define the string
	var aKey ='';
	var sKey ='';
	var reg = '';
   var region='';
   $http.get('./config.json').then(function (response) {
	    var app =  response.data;
        AWS.config.update({
            accessKeyId : Base64.decode(app.aKey),
            secretAccessKey : Base64.decode(app.sKey),
            region : Base64.decode(app.reg)
        });
	    });
    $scope.submitForm = function (file) {
    	$scope.projectGroupCode = $sessionStorage.account.projectGroup.projectGroupCode;
        $scope.infoTextAlert = "Please wait uploading....";
        $scope.showInfoAlert = true;
   $scope.showSuccessAlert = false;
     $scope.showErrorAlert = false;
     
  var bucket = new AWS.S3({params: {Bucket: $sessionStorage.account.projectGroup.bucketName.toLocaleLowerCase(),Prefix:'testfolder'}});
    var fileChooser = $("input[type='file'")[0];
    var file1 = fileChooser.files[0];
    if (file1) {
    var params = {Key: file1.name, ContentType: file1.type, Body: file1,xhrFields: {
      withCredentials: true }};
    bucket.upload(params).on('httpUploadProgress', function(evt) {
    console.log("Uploaded :: " + parseInt((evt.loaded * 100) / evt.total)+'%');
 
   $(".bg-info").html( "Please wait uploading.... " + parseInt((evt.loaded * 100) / evt.total)+'%');
        
     
 
    }).send(function(err, data) {
   // alert("File uploaded successfully.");
    	 if (err) {
    		 $scope.successTextAlert = "There was an error uploading your Hmis upload:"+ err.message;
    	      return false;
    	    }
        $scope.fileName = file1.name;
        $scope.bucketName = 'sdolia-2015';
      //  $scope.fileSize = file1.size;
        Service.bulkupload($http, $scope,file,
 //success
            function () {
                $scope.switchBool("showInfoAlert");
                $scope.successTextAlert = "File has been uploaded successfully.";
    $scope.showInfoAlert = false;
                $scope.showSuccessAlert = true;
    
    $location.path("/admin/managefiles");
            },
//error
       function () {
     $location.path("/admin/managefiles");
           $scope.switchBool("showInfoAlert");
           $scope.errorTextAlert = "Error, Something gone wrong.";
     $scope.showInfoAlert = false;
           $scope.showErrorAlert = true;
           
       })
    
 
    });
    }
        return false;
    }

    // switch flag
    $scope.switchBool = function (value) {
        $scope[value] = !$scope[value];
    };

}]);


