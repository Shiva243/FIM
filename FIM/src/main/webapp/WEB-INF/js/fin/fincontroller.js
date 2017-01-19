var app = angular.module("finApp", [ "ui.grid" ]);
app
		.controller(
				"finController",
				function($scope, $filter, $http, $window) {
					$scope.createdDate = $filter("date")(Date.now(),
							'yyyy-MM-dd');
					$scope.chitMonths = 10;
					$scope.intrestRate = 1;
					$scope.gridOptions = { enableColumnMenus: false};
					$scope.gridOptions.onRegisterApi = function(gridApi) {
						$scope.gridApi = gridApi;
					};
					
					$http.get("/getfindetails").then(function(response) {
						console.log(response.data);
						$scope.gridOptions.data = response.data;
						console.log($scope.gridOptions.data);
					});
					$scope.chitnameexsist = function() {
						$scope.chitnameerror = '';
						$http
								.get("/chitnameexsist", {
									params : {
										'chitName' : $scope.chitName
									}
								})
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
							chitName : $scope.chitName,
							intrestRate : $scope.intrestRate,
							createdDate : $scope.createdDate
						};
						console.log("log" + angular.toJson(data));
						$http.post("/addfindetail", angular.toJson(data)).then(
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
					$scope.searchchitname = function() {
						console
								.log("Inside searchchitamount amountSearch value is ["
										+ $scope.amountSearch + "]");
						$http
								.get("/getfindetails", {
									params : {
										'chitName' : $scope.nameSearch
									}
								})
								.then(
										function(response) {
											console
													.log("Inside searchchitamount response is ["
															+ response.data
															+ "]");
											//$scope.gridOptions = {};
											$scope.gridOptions.data = response.data;
											//$scope.gridApi.grid.refresh();
										},
										function(errResponse) {
											console
													.log("Inside searchchitamount ["
															+ errResponse
															+ "] value");
										});
					}
						
				});

