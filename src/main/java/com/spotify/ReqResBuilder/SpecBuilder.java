package com.spotify.ReqResBuilder;

import com.spotify.route.Route;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.spotify.route.Route.*;

public class SpecBuilder {
    public static RequestSpecification getRequestSpec(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("https://api.spotify.com")
                .setBasePath(BASE_PATH)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL);

        return requestSpecBuilder.build();
    }

    public static RequestSpecification getAccountRequestSpec(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("https://accounts.spotify.com")
                .setBasePath(API + TOKEN)
                .setContentType(ContentType.URLENC)
                .log(LogDetail.ALL);

        return requestSpecBuilder.build();
    }

    public static ResponseSpecification getResponseSpec(){
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL);

        return responseSpecBuilder.build();
    }
}
