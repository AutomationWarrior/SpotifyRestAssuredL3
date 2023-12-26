package com.spotify.client;

import com.spotify.dto.Playlist.Playlist;
import io.restassured.response.Response;

import static com.spotify.route.Route.PLAYLIST;
import static com.spotify.route.Route.USERS;
import static com.spotify.tokenManager.TokenManager.getAccessToken;

public class UserClient {

    public static Response createUser(Playlist requestPlaylist){
        return SimpleClient.post(USERS+"/31tajp4w6u4syg4evc4glc7qsubi" + PLAYLIST, getAccessToken(), requestPlaylist);
    }

    public static Response deleteUser(){
        Response response = null;
        return response;
    }
}
