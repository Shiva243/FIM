var finService= angular.module('FinService',[]);
finService.factory('finData',['$http',function($http){
	
	var findata={};
	var shareFinService =this;
	 shareFinService.getSelect=""; 
	findata.chitnameexsist = function(chitName){
		console.log("chitName "+chitName);
		return $http.get("/chitnameexsist",{params: {'chitName': chitName}});
	}
	findata.addfindetail=function(data){
		return $http.post("/addfindetail", angular.toJson(data));
	}
	findata.searchchitname=function(chitName){
		return $http.get("/getfindetails",{params: {'chitName': chitName}});
	}
	
	return findata;
}]);

