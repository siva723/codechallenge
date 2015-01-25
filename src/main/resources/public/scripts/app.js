/**
 * Created by sivakumaran
 */
var app = angular.module('appa', [
    'ngCookies',
    'ngResource',
    'ngSanitize',
    'ngRoute'
]);

app.config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'views/list.html',
        controller: 'ListCtrl'
    }).when('/create', {
        templateUrl: 'views/create.html',
        controller: 'CreateCtrl'
    }).otherwise({
        redirectTo: '/'
    })
});

app.controller('ListCtrl', function ($scope, $http) {
    $http.get('/service/announcements').success(function (data) {
        $scope.announcements = data;
    }).error(function (data, status) {
        console.log('Error ' + data)
    })

    $scope.announcementEdit = function (announcement) {        
    	 
        $http.put('/service/announcements/' + announcement.id, announcement).success(function (data) {           
        }).error(function (data, status) {
            console.log('Error ' + data)
        })
    }
    
    $scope.announcementDelete = function (announcement) {        
        $http.delete('/service/announcements/' + announcement.id, announcement).success(function (data) {
            
        }).error(function (data, status) {
            console.log('Error ' + data)
        })
    }
});

app.controller('CreateCtrl', function ($scope, $http, $location) {
    $scope.announcements = {
        done: false
    };

    $scope.createAnnouncement = function () {
        
        $http.post('/service/announcements', $scope.announcement).success(function (data) {
            $location.path('/');
        }).error(function (data, status) {
            console.log('Error ' + data)
        })
    }
});