(function() {
  'use strict';

  angular.module('starter')
    .controller(
    'OrdersCtrl',
    function($scope) {
      $scope.orders = [
        {
          id: 3,
          items: [
            {name: 'Chicken Tikka Masala', count: 2},
            {name: 'Mango Lassi', count: 3}
          ]
        },
        {
          id: 4,
          items: [
            {name: 'Steak Supreme Tacos', count: 2},
            {name: 'Chicken Supreme Tacos', count: 3}
          ]
        }
      ];

      $scope.completeOrder = function(order) {
        _.remove($scope.orders, order);
      }
    });
})();