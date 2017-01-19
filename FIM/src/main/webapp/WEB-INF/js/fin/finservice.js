var userService= angular.module('FinService',[]);
userService.factory('finData',['$http',function($http){
	
	var findata={};
	findata.chitamountexsist = function(chitAmount){
		console.log("chitAmount "+chitAmount);
		return true;
	}
	return findata;
}]);

