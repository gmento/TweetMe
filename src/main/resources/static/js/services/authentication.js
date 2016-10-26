angular.module('app').service('UserInfo', function ($http) {	
	
	this.name="Giuseppe";
	this.user="";
	//var headers="gg";
	this.collect = function(){
		$http.get('/user').success(function(data) {
		        user=data;
		        console.log("succ Loggato on id:"+ this.user.name);
		        
		        //return data;
		      //callback && callback();
	  	}).error(function() {
			     
			      console.log("Errore");
	  	});
		return "ciii";
	};
});

angular.module('app').service('authInterceptor', function($q,$location) {
    var service = this;

    service.responseError = function(response) {
        if (response.status == 401){
        	console.log("Sorry you are not autheticated...");
        	$location.path("/login");
        }
        return $q.reject(response);
    };
});
