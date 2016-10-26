angular.module('app').controller("userdataCtr", function($scope, $http) {
//preparing data for the User profile
	
	 var url = "http://localhost:8090/api/v1/userprofile";
	 var url_userid =url + "/" +$scope.user.id;
	 console.log("collecting data from:" + url);
	 
	 var req ={
			 method: 'GET',
			 url : url_userid
			 };
	 
	 //collecting data from user profile
	 $http(req)
		.then(function(response) {
	      //First function handles success
	      $scope.userprofile = response.data;
	      console.log($scope.userprofile);
	      return "cao";
	  	}, function(response) {
	      //Second function handles error
	      console.log("Something went wrong with the user profile");	 
			});
	 
	
	 
});


/**

*/

angular.module('app').controller("userupdateCtr", function($scope, $http) {
	
	 var url = "http://localhost:8090/api/v1/userprofile";
	 //update user profile data  
	 $scope.update_userprofile = function(){
		 //$scope.$apply();
		 console.log("trying update data");
		 

		 console.log($scope.userprofile);
		 
		 $http.put(url, $scope.userprofile)
			.then(function(response) {
		      //First function handles success
		      //$scope.userprofile = response.data;
		      console.log("update successfully completed:");
		      console.log($scope.userprofile);
		      //return "";
		  	}, function(response) {
		      //Second function handles error
		      console.log("Something went wrong with the user profile update:"+ response.message);	 
				});
		 
		 
	 };
});
