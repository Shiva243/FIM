var app = angular.module("userApp", ['ui.grid','ui.bootstrap','UserService']);
app
		.controller(
				"userController",
				function($scope, $http, $window,$modal,UserData) {
					
					$scope.userGridOptions = { enableColumnMenus: false};
					 $scope.userGridOptions.columnDefs = [{
				            name: 'Action',
				            cellTemplate: '<img ng-src="././images/user/userlist/edituser.jpeg" ng-click="grid.appScope.editusermodal(row)">&nbsp;&nbsp;<img ng-src="././images/user/userlist/deluser.png" ng-click="grid.appScope.deleteusermodal(row)">'
				        }, {
				            name: 'firstName',
				            field: 'firstName'
				        }, 
				        {
				            name: 'lastName',
				            field: 'lastName'
				        },
				        {
				            name: 'userName',
				            field: 'userName'
				        },
				        {
				            name: 'age',
				            field: 'age'
				        },
				        {
				            name: 'Gendar',
				            field: 'gendar'
				        },{
				            name: 'mobileNumber',
				            field: 'mobileNo'
				        },{
				            name: 'createdDate',
				            field: 'createdDate'
				        },{
				            name: 'modifyDate',
				            field: 'modifyDate'
				        }];
					
					$scope.userGridOptions.onRegisterApi = function(gridApi) {
						$scope.gridApi = gridApi;
					};
					$scope.pagination = {
					        pageSize: 5,
					        pageNumber: 1,
					        totalItems: null
					}
					$http.get("/getuserlist").then(function(response) {
						console.log(response.data.slice(0,5));
						$scope.userGridOptions.data = response.data;
						  $scope.pagination.totalItems =response.data.length;
						console.log($scope.userGridOptions.data);
					});
					$scope.addUser=function(){
						//$window.location.href="/userhome";
						UserData.getSelect='';
						var modalInstance= $modal.open({
			        		 templateUrl: '/adduser.html',
			        		 controller: 'addUserController'
						  });
					}
					$scope.deleteusermodal = function(row) {
						 UserData.getSelect=row.entity;
						  var modalInstance= $modal.open({
			        		 templateUrl: '/deletefin.html',
			        		 controller: 'userDeleteController'
						  });
						
			        };
			        $scope.editusermodal=function(row){
			        	UserData.getSelect=row.entity;
						var modalInstance= $modal.open({
			        		 templateUrl: '/adduser.html',
			        		 controller: 'addUserController'
						  });
					}
				});
app
.controller(
		"addUserController",
		function($scope,$window,$http,UserData) {
			if(UserData.getSelect!=''){
				$scope.firstName=UserData.getSelect.firstName;
				$scope.lastName=UserData.getSelect.lastName;
				$scope.userName=UserData.getSelect.userName;
				$scope.age=parseInt(UserData.getSelect.age);
				 $scope.idNo=UserData.getSelect.idNo;
				$scope.mobileNo=UserData.getSelect.mobileNo;
				 $scope.gendar=UserData.getSelect.gendar;
				 $scope.address=UserData.getSelect.address;
			}
			$scope.usernameexsist = function() {
				/*console.log("validusername() "
						+ $scope.userName);*/
				$scope.usernameerror = '';
				UserData
						.usernameexsist($scope.userName)
						.then(
								function(response) {
									if (response.data.status == 'Fail') {
										$scope.usernameerror = 'This UserName already exsist, Please enter valid UserName.';
									}
								})
			}
			$scope.useridexsist = function() {
				//console.log("useridexsist() " + $scope.idNo);
				$scope.idnoerror = '';
				UserData
						.useridexsist($scope.idNo)
						.then(
								function(response) {
									if (response.data.status == 'Fail') {
										$scope.idnoerror = 'This IdNo already exsist, Please enter different IdNo.';
									}
								})
			}
			$scope.mobilenoexsist = function() {
				/*console.log("mobilenoexsist() "
						+ $scope.mobileNo);*/
				$scope.mobilenoerror = '';
				UserData
						.mobilenoexsist($scope.mobileNo)
						.then(
								function(response) {
									console.log("mobilenoexsist() "
											+ response.data.status);
									if (response.data.status == 'Fail') {
										$scope.mobilenoerror = 'This MobileNo already exsist, Please enter another MobileNo.';
									}
								})
			}
			$scope.addUser = function(valid) {
				if (valid) {
					var data='';
					if(UserData.getSelect!=''){
					data={
						_id:UserData.getSelect._id,	
						firstName:$scope.firstName,
						 lastName:$scope.lastName,
						 userName:$scope.userName,
						 age:$scope.age,
						 idNo:$scope.idNo,
						 mobileNo:$scope.mobileNo,
						 gendar:$scope.gendar,
						 address:$scope.address	
					};
					}else{
						data={
							firstName:$scope.firstName,
							 lastName:$scope.lastName,
							 userName:$scope.userName,
							 age:$scope.age,
							 idNo:$scope.idNo,
							 mobileNo:$scope.mobileNo,
							 gendar:$scope.gendar,
							 address:$scope.address	
						};
					}
					console.log("addUser Json data is ["
							+ angular.toJson(data) + "]");
					UserData
							.addUser(angular.toJson(data))
							.then(
									function(response) {
										$window.location.reload();
									},
									function(errorResponse) {
										alert("Can't able to add user, please try after some time");
									});
				}
			}
			$scope.cancel = function() {
				$window.location.reload();
			}

		
			
		});
app.controller("userDeleteController", function($scope,$http,UserData,$modalInstance,$window){
	$scope.ok=function(){
		 $http.delete("/deleteuser",{
				params : {
					'userId' : UserData.getSelect._id
				}
			}).then(function(response){
				$window.location.reload();
			},function(errorResponse){
				alert("can't able to delete the record, there is some internal issue");
			});
	}
	$scope.cancel = function () {
		$modalInstance.close();
		};
});

