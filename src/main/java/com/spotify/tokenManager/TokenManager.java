package com.spotify.tokenManager;

import com.spotify.client.SimpleClient;
import com.spotify.utils.ConfigLoader;
import io.restassured.response.Response;

import java.time.Instant;
import java.util.HashMap;

public class TokenManager {
    private static String accessToken;

    private static Instant expiryTime;
    public static String getAccessToken(){
        Response response = renewToken();
        try{
            if(accessToken == null || Instant.now().isAfter(expiryTime)){
                System.out.println("Renewing token");

//                Response response = renewToken();
                // Get value of access_token
                accessToken = response.path("access_token");

                int expiryDurationInSecond = response.path("expires_in");

                expiryTime = Instant.now().plusSeconds(expiryDurationInSecond - 300);
            }else{
                System.out.println("Token is good to use");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return accessToken;

    }

    public static Response renewToken(){
        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("grant_type", ConfigLoader.getInstance().getPropertyName("grant_type"));
        formParams.put("refresh_token", ConfigLoader.getInstance().getPropertyName("refresh_token"));
        formParams.put("client_id", ConfigLoader.getInstance().getPropertyName("client_id"));
        formParams.put("client_secret", ConfigLoader.getInstance().getPropertyName("client_secret"));

        Response response = SimpleClient.postAccount(formParams);

        return response;
    }
}
