/**


*/

angular.module('app').controller("BodyCrl", function($scope) {
		//AUTHENTICATION TEST
		//Authentication.authenticate();
		//$scope.login ={token : Authentication.token, iduser : Authentication.iduser};
		//initialising variables
		//default page
		$scope.webpage= "view/home/dashboard.html";
		console.log ("BodyCrl started: token:, userid:");
		
        //create a swith for the main menu
        $scope.page = function(webpage) {
        	console.log ("hai cliccato: " + webpage);
        	$scope.webpage= webpage;
        };
        
        $scope.templateUrl = function() {
        	//demo.initChartist();
        	return $scope.webpage;
            
          }
        
    });
