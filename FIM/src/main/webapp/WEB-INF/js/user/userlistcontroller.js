var app = angular.module("userApp", ['ui.grid']);
app
		.controller(
				"userController",
				function($scope, $http, $window) {
					
					$scope.userGridOptions = { enableColumnMenus: false};
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
				});