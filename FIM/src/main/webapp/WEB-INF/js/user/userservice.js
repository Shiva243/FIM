var userService= angular.module('UserService',[]);
userService.factory('UserData',['$http',function($http){
	var userdata={};
	var userShareService=this;
	userShareService.getSelect="";
	userdata.usernameexsist = function(userName){
		console.log("userName "+userName)
		return $http.get("/usernameexsist",{params: {'userName': userName}});
	}
	userdata.useridexsist = function(idNo){
		console.log("idNo "+idNo)
		return $http.get("/useridexsist",{params: {'idNo': idNo}});
	}
	userdata.mobilenoexsist = function(mobileNo){
		console.log("mobileNo "+mobileNo)
		return $http.get("/mobilenoexsist",{params: {'mobileNo': mobileNo}});
	}
	userdata.addUser = function(userInfo){
		console.log("Inside service userInfo ["+userInfo._id+"")
		return $http.post("/adduser", userInfo);
	}
	userdata.getAllUsers = function(){
		return $http.post("/empList", "");
	}
	return userdata;
}]);

