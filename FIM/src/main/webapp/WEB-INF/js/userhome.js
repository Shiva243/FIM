var app = angular.module("empform", []);
app.controller("empController", function($scope, $http, $window) {
	var self = this;
	self.user = {
		empName : '',
		empId : '',
		designation : '',
		empSalary : ''
	};
	$http.post("/empList", "").then(function(response) {
		$scope.records = response.data;
	});
	$scope.empc.modify = function(emp) {

		$scope.empc.modifyField = true;
		$scope.empc.viewField = true;
	};

	$scope.empc.update = function(emp) {
		$scope.empc.modifyField = false;
		$scope.empc.viewField = false;
	};
	$scope.validusername=function(){
		console.log("validusername() "+$scope.empc.user.userName);
		$scope.usernameerror='';
		$http.post("/usenamevalid",$scope.empc.user.userName).then(function(response) {
			if(response.data.status=='false'){
				$scope.usernameerror='This UserName already exsist, Please enter valid UserName.';
			}
		});
	}
	$scope.add = function(valid) {
		if (valid) {
			var data = {
				empName : $scope.empc.user.empName,
				empId : $scope.empc.user.empId,
				designation : $scope.empc.user.designation,
				empSalary : $scope.empc.user.empSalary

			};
			console.log(angular.toJson(data) + " " + valid);
			$http.post("/addEmp", data).then(function(response) {
				console.log(response)
				if (response.data.status == 'success') {
					console.log(response.data.status);
					$window.location.href = '/emphome';
				}
			});
		}else{
			console.log("invalid");
		}

	};
});