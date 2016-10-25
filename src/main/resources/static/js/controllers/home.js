angular.module('app').controller('home_crl', function($rootScope, $http, $scope, UserInfo){
	
	$scope.user={name:"",authority:""};
	
	$http.get('/user').success(function(data) {
        $scope.user=data;
        $scope.user.id=3;
        console.log("succ Loggato on id:"+ $scope.user);
        //return data;
      //callback && callback();
	}).error(function() {
	     
	      console.log("Errore");
	});
	//$scope.user.authority = UserInfo.data.authority;
	console.log("A.userInfo:"+ $scope.user);
	//demo.initChartist();
})