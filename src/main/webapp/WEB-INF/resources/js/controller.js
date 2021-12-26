var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http) {

    $scope.refreshCart = function (cartId) {
        $http.get("/myStore/rest/cart/" + $scope.cartId).then(function (response) {
            $scope.cart = response.data;
        },function error(response) {
            $scope.msg="error"
            alert(response.msg);
        });
    };

    $scope.clearCart = function () {
        $http.delete("/myStore/rest/cart/" + $scope.cartId).success($scope.refreshCart($scope.cartId));
    };
    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };
    $scope.addToCart=function(productId){
        $http({
            method: 'PUT',
            url: '/myStore/rest/cart/add/'+productId
        }).then(function (response){

            $scope.refreshCart($http.get("/myStore/rest/cart/cartId"));
            alert("Product successfully added to the cart!");
        },function myError(response) {
            alert(response.msg);
        });
    };
    $scope.removeFromCart=function (productId){
        $http({
            method:'PUT',
            url:'/myStore/rest/cart/remove/'+productId
        }).then (function (response){
            $scope.refreshCart($http.get("/myStore/rest/cart/cartId"));
        },function myError(response){
            alert(response.msg);
        })
    };
});