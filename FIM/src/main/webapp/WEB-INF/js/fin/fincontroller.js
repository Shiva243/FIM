var app = angular.module("finApp", [ 'ui.grid','FinService','ui.bootstrap' ]);
app
		.controller(
				"finController",
				function($scope, $filter, $http, $window,finData) {
					$scope.createdDate = $filter("date")(Date.now(),
							'yyyy-MM-dd');
					$scope.chitMonths = 10;
					$scope.intrestRate = 1;
					/*$scope.gridOptions = { enableColumnMenus: false};
					$scope.gridOptions.onRegisterApi = function(gridApi) {
						$scope.gridApi = gridApi;
					};
					
					$http.get("/getfindetails").then(function(response) {
						console.log(response.data);
						$scope.gridOptions.data = response.data;
						console.log($scope.gridOptions.data);
					});*/
					$scope.chitnameexsist = function() {
						$scope.chitnameerror = '';
						finData.chitnameexsist($scope.chitName)
								.then(
										function(response) {
											console
													.log("chitamountexsist response ["
															+ response.data.chitAmount
															+ "] value"
															+ $scope.chitAmount);
											if (response.data.chitName == $scope.chitName) {
												console
														.log("inside chitamountexsist response ["
																+ response.data.chitAmount
																+ "] ");
												$scope.chitnameerror = "Already exsist, please enter the different Name."
												$scope.finform.chitName
														.$setValidity(
																"duplicate",
																false);
											} else {
												$scope.finform.chitName
														.$setValidity(
																"duplicate",
																true);
											}

										},
										function(errResponse) {
											console
													.log("chitamountexsist failed ["
															+ errResponse
															+ "] value");
										});
					}
					$scope.addfindetail = function(valid) {
						console.log($scope.createdDate + "valid" + valid);
						var data = {
							chitAmount : $scope.chitAmount,
							chitMonths : $scope.chitMonths,
							chitName : angular.uppercase($scope.chitName),
							intrestRate : $scope.intrestRate,
						createdDate : $scope.createdDate
						};
						console.log("log" + angular.toJson(data));
						finData.addfindetail(data).then(
								function(response) {
									console.log("addfindetail response ["
											+ response.data + "] value");
									// $scope.chitAmount='';
									// $route.reload();
									$window.location.reload();
								},
								function(errResponse) {
									console.log("addfindetail failed ["
											+ errResponse + "] value");
								});
					}
					
						
				});

app
		.controller(
				"gridController",
				function($scope,  $http, $window,finData,$modal) {
					$scope.gridOptions1 = { enableColumnMenus: false};
					 $scope.gridOptions1.columnDefs = [{
				            name: 'Action',
				            cellTemplate: '<img ng-src="././images/fin/del.jpg" ng-click="grid.appScope.deletemodal(row)"> <img ng-src="././images/fin/edit.png" ng-click="grid.appScope.editmodal(row)" >'
				        }, {
				            name: 'chitName',
				            field: 'chitName'
				        }, 
				        {
				            name: 'chitAmount',
				            field: 'chitAmount'
				        },
				        {
				            name: 'chitMonths',
				            field: 'chitMonths'
				        },
				        {
				            name: 'intrestRate',
				            field: 'intrestRate'
				        },
				        {
				            name: 'createdDate',
				            field: 'createdDate'
				        },{
				            name: 'modifyDate',
				            field: 'modifyDate'
				        }];
					
					$scope.gridOptions1.onRegisterApi = function(gridApi) {
						$scope.gridApi = gridApi;
					};
					
					$http.get("/getfindetails").then(function(response) {
						$scope.gridOptions1.data = response.data;
						console.log($scope.gridOptions1.data);
					});
					$scope.searchchitname = function() {
						console
								.log("Inside searchchitname  value is ["
										+ $scope.nameSearch + "]");
						finData.searchchitname($scope.nameSearch)
								.then(
										function(response) {
											console
													.log("Inside searchchitname response is ["
															+ response.data._id
															+ "]");
											//$scope.gridOptions = {};
											if(response.data!=''){
												$scope.gridOptions1.data = response.data;
											}
											
											//$scope.gridApi.grid.refresh();
										},
										function(errResponse) {
											console
													.log("Inside searchchitname ["
															+ errResponse
															+ "] value");
										});
					}
					
					$scope.deletemodal = function(row) {
						 console.log(row.entity._id);
						 $window.alert("Are you sure delete the record?")
						 $http.delete("/deletefindetail",{
								params : {
									'id' : row.entity._id
								}
							}).then(function(response){
								console.log("delete successfully");
								$window.location.reload();
							},function(errorResponse){
								console.log("can't able to delete the record, there is some internal issue");
							});
			        };
			        $scope.editmodal = function(row) {
			        	 finData.getSelect=row.entity;
			        	 console.log(finData.getSelect);
			        	 var modalInstance= $modal.open({
			        		 templateUrl: '/updatefin.html',
			        		 controller: 'finUpdateController',
			        		 bindings: {
			        			    resolve: '<',
			        			    close: '&',
			        			    dismiss: '&'
			        			  },
			        		 });
			        };
						
				});
app
.controller(
		"finUpdateController",
		function($scope,$window,$http,finData,$modalInstance) {
			 console.log(finData.getSelect);
			 var $ctrl = this;
			$scope.chitName=finData.getSelect.chitName;
			 $scope.chitAmount=parseInt(finData.getSelect.chitAmount);
			$scope.chitMonths=parseInt(finData.getSelect.chitMonths);
			$scope.intrestRate=parseFloat(finData.getSelect.intrestRate);
			$scope.createdDate=new Date(finData.getSelect.createdDate);
			$scope.updatefindetail=function(valid){
				if(valid){
					var data = {
						chitAmount : $scope.chitAmount,
						chitMonths : $scope.chitMonths,
						chitName : $scope.chitName,
						intrestRate : $scope.intrestRate,
					};
					console.log(angular.toJson(data));
					$http.post("/updatefindetail",angular.toJson(data)).then(function(response){
						console.log(response);
						$window.location.reload();
					})
				}
			}
			$scope.close = function () {
				//$window.location.reload();
				$modalInstance.close();
				};
		});

