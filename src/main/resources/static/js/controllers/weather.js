angular.module('app').controller("weather-ctr", function($scope, $http) {

  $scope.citta = "Roma";
  //$scope.myposition = GeoPosition.position;
  //Calculate the weather
  var code='9e12543db2b7a23892f3ff874aef3e32';
  var url = "http://api.openweathermap.org/data/2.5/weather?q=" +$scope.citta +"&appid="+code+"&units=metric&lang=it";
  //var url = "api.openweathermap.org/data/2.5/weather?lat=" + GeoPosition.lat; + "&lon=" + GeoPosition.lng + "&appid="+code+"&units=metric&lang=it";
	console.log("function wheater:" + url);
	 
	
	//$http.defaults.headers.common["X-Requested-With"] ="XMLHttpRequest";
	//this line delete the X-Requested-With condition, no requested by openweather.com.
	//this header line is sent to identify the JQUERY request
	delete $http.defaults.headers.common["X-Requested-With"];
	
	var req ={
			 method: 'GET',
			 url : url
			 };
	
	
	 $http(req)
		.then(function(response) {
	      //First function handles success
	      $scope.content = response.data;
	      console.log($scope.content);
	      return "cao";
	  	}, function(response) {
	      //Second function handles error
	      console.log("Error weather-ctr");	 
			});
});