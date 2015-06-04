'use strict';

// Declare app level module which depends on views, and components
var app = angular.module('playerWeb', [
    'ngRoute', 'ngDialog', 'player.web.services.rest', 'player.web.controllers.tab', 'player.web.controllers.album',
    'player.web.controllers.artist', 'player.web.controllers.genre', 'player.web.controllers.song'
]);
app.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {
    $routeProvider.when('/songs', {
        templateUrl: 'view/songs.html',
        controller: 'SongController'
    }).when('/artists', {
        templateUrl: 'view/artists.html',
        controller: 'ArtistController'
    }).when('/genres', {
        templateUrl: 'view/genres.html',
        controller: 'GenreController'
    }).when('/albums', {
        templateUrl: 'view/albums.html',
        controller: 'AlbumController'
    }).otherwise({redirectTo: '/songs'});

    $httpProvider.defaults.useXDomain = true;
}]);

