package com.spotify.client;

import com.spotify.ReqResBuilder.SpecBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static com.spotify.ReqResBuilder.SpecBuilder.*;

public class SimpleClient {

    public static Response post(String path, String accessToken, Object requestObject){
        return RestAssured.given(getRequestSpec())
                .body(requestObject)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .post(path)
                .then().spec(getResponseSpec()).extract().response();
    }

    public static Response get(String path, String accessToken){
        return RestAssured.given(getRequestSpec())
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get(path)
                .then().spec(getResponseSpec()).extract().response();
    }

    public static Response put(String path, String accessToken, Object requestObject){
        return RestAssured.given(getRequestSpec())
                .body(requestObject)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .put(path)
                .then().spec(getResponseSpec()).extract().response();
    }

    public static Response postAccount(HashMap<String, String> formParams) {
        return RestAssured.given(getAccountRequestSpec())
                .formParams(formParams)
                .when()
                .post()
                .then().spec(SpecBuilder.getResponseSpec()).extract().response();
    }
}
