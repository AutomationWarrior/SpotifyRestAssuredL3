package com.spotify.client;

import com.spotify.dto.Playlist.Playlist;
import io.restassured.response.Response;

import static com.spotify.route.Route.PLAYLIST;
import static com.spotify.route.Route.USERS;
import static com.spotify.tokenManager.TokenManager.getAccessToken;

public class UserClient {

    public static Response createUser(Playlist requestPlaylist){
        return SimpleClient.post(USERS+"/" + PLAYLIST, getAccessToken(), requestPlaylist);
    }

    public static Response deleteUser(){
//        return SimpleClient.post(USERS+"/" + PLAYLIST, getAccessToken(), null);
        System.out.println("abcbndbn");
        return null;
    }
}
