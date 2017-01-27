var app = angular.module("empform", [ 'UserService' ]);
app
		.controller(
				"empController",
				function($scope, UserData, $window) {
					
					
					$scope.usernameexsist = function() {
						console.log("validusername() "
								+ $scope.empc.user.userName);
						$scope.usernameerror = '';
						UserData
								.usernameexsist($scope.empc.user.userName)
								.then(
										function(response) {
											if (response.data.status == 'false') {
												$scope.usernameerror = 'This UserName already exsist, Please enter valid UserName.';
											}
										})
					}
					$scope.useridexsist = function() {
						console.log("useridexsist() "
								+ $scope.empc.user.idNo);
						$scope.idnoerror = '';
						UserData
								.useridexsist($scope.empc.user.idNo)
								.then(
										function(response) {
											if (response.data.status == 'false') {
												$scope.idnoerror = 'This IdNo already exsist, Please enter different IdNo.';
											}
										})
					}
					$scope.mobilenoexsist = function() {
						console.log("mobilenoexsist() "
								+ $scope.empc.user.mobileNo);
						$scope.mobilenoerror ='';
						UserData
								.mobilenoexsist($scope.empc.user.mobileNo)
								.then(
										function(response) {
											console.log("mobilenoexsist() "
													+response.data.status);
											if (response.data.status == 'false') {
												$scope.mobilenoerror = 'This MobileNo already exsist, Please enter another MobileNo.';
											}
										})
					}
					$scope.addUser = function(valid) {
						if (valid) {
							console.log("addUser Json data is [" +angular.toJson($scope.empc.user) + "]");
							UserData.addUser(angular.toJson($scope.empc.user)).then(function(response) {
								alert("User Registration Successfully");
								$window.location.href = '/userlist';
							},function(errorResponse){
								alert("Can't able to add user, please try after some time");
							});
						}
					}

				});