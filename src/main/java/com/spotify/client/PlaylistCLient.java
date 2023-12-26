package com.spotify.client;

import com.spotify.dto.Playlist.Playlist;
import com.spotify.route.Route;
import com.spotify.tokenManager.TokenManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static com.spotify.ReqResBuilder.SpecBuilder.getRequestSpec;
import static com.spotify.ReqResBuilder.SpecBuilder.getResponseSpec;
import static com.spotify.route.Route.PLAYLIST;
import static com.spotify.route.Route.USERS;
import static com.spotify.tokenManager.TokenManager.getAccessToken;
import static io.restassured.RestAssured.given;

public class PlaylistCLient {
    static String accessToken = "BQCxg4IfYB5m8JDiduwe9zLA2yGRTqbsxsQJvUTSupYjII4rg0tPSNyrCNxE2d77lLWrbTq8mFbqYdRC0W83UagtGa1_eM8Dfj5mTz5cdMWrSTk9AJnRRi8QxZunmBbJclBrPRyV1UQdjVOEYLkefud1Fa1S4rsvLyn7uuKSWjuRu5Bmqsx21iEOc1_ubn9uQwXTy8ZJXWeUKZnUGdfv9u3QOjej-N2YHtPa1ZTJ4BQYYWfSazpdK0hE8f7s0O-F5yKvrWkH7Em5l5fb";
    public static Response createPlaylist(Playlist requestPlaylist){
        return SimpleClient.post(USERS+"/31tajp4w6u4syg4evc4glc7qsubi" + PLAYLIST, getAccessToken(), requestPlaylist);
    }

    public static Response getPlaylistById(String playlistId){

       return SimpleClient.get(PLAYLIST +"/"+ playlistId, getAccessToken());
    }

    public static Response updatePlaylistByPlaylistID(String playListId, Playlist requestPlaylist) {
        return SimpleClient.put(PLAYLIST+"/" + playListId, getAccessToken(), requestPlaylist);
    }
}
