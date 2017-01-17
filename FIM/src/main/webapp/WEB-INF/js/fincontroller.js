var app = angular.module("finApp", ["ui.grid"]);
app.controller(
		"finController",
		function($scope,$filter,$http,$window){
			$scope.createdDate=$filter("date")(Date.now(), 'yyyy-MM-dd');
			$scope.chitMonths=10;
			$scope.intrestRate=1;
			$scope.gridOptions = {};
			$http.get("/getfindetails","")
				.then(function(response) {
					console.log(response.data);
					$scope.gridOptions = {
					        excludeProperties: '__metadata',
					    };
					$scope.gridOptions.data=response.data;
					console.log($scope.gridOptions.data);
			});
			$scope.chitamountexsist=function(){
				$scope.chitamounterror='';
				$http.get("/chitamountexsist",{params: {'chitAmount': $scope.chitAmount}}).then(function(response){
					console.log("chitamountexsist response ["+response.data.chitAmount+"] value"+$scope.chitAmount);
					if(response.data.chitAmount == $scope.chitAmount){
						console.log("inside chitamountexsist response ["+response.data.chitAmount+"] ");
						$scope.chitamounterror="Already exsist, please enter the different value."
						$scope.finform.chitAmount.$setValidity("duplicate", false);
					}else{
						$scope.finform.chitAmount.$setValidity("duplicate", true);
					}
					
				},function(errResponse){
					console.log("chitamountexsist failed ["+errResponse+"] value");
				});
			}
			$scope.addfindetail=function(valid){
				console.log($scope.createdDate+"valid"+valid);
				var data={
						chitAmount:$scope.chitAmount,
						chitMonths:$scope.chitMonths,
						intrestRate:$scope.intrestRate,
						createdDate :$scope.createdDate
				};
				console.log("log"+angular.toJson(data));
				$http.post("/addfindetail",angular.toJson(data)).then(function(response){
					console.log("addfindetail response ["+response.data+"] value");
					//$scope.chitAmount='';
					//$route.reload();
					$window.location.reload();
				},function(errResponse){
					console.log("addfindetail failed ["+errResponse+"] value");
				});
			}
			$scope.searchchitamount=function(){
				console.log("Inside searchchitamount amountSearch value is ["+$scope.amountSearch+"]");
				http.get("/chitamountexsist",$scope.amountSearch).then(function(response){
					console.log("Inside searchchitamount response is ["+response.data+"]");;
				},function(errResponse){
					console.log("Inside searchchitamount ["+errResponse+"] value");
				});
			}
		});
