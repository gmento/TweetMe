/*------------------------------------*\
    ANGULAR JS LOGIN
\*------------------------------------*/

angular.module('app').controller('login_crl', function($rootScope, $http, $scope, $location, httpHeader ){
	
	$scope.credentials = {username:"",password:""};
	//creating the header from the login
	
	console.log("Welcome to the Log-in. Please insert your credential.");
	console.log("username:"+$scope.credentials.username);
	
	
	//login function
	$scope.login_sub = function(){
		console.log("starting log in...");
		console.log("Creating header with username:" + $scope.credentials.username + " and password " + $scope.credentials.password);
		
		
		var headers = $scope.credentials ? {authorization : "Basic " + btoa($scope.credentials.username + ":" + $scope.credentials.password)} : {};
		
		httpHeader.header=headers;
		
		console.log("header:"+ headers.authorization);
		
		$http.get('/user', {headers : headers}).success(function(data) {
		      if (data.name) {
		        $rootScope.authenticated = true;
		        console.log("Loggato on id:"+ data.name);
		        $location.path("/home");
		      } else {
		        $rootScope.authenticated = false;
		        console.log("Errore"+data);
		      }
		      //callback && callback();
	    	}).error(function() {
			      $rootScope.authenticated = false;
			      console.log("Errore");
			      //$location.path("login");
			      //callback && callback();
	    });
	}
})
