package com.spotify;

import com.spotify.ReqResBuilder.SpecBuilder;
import com.spotify.client.PlaylistCLient;
import com.spotify.dto.Error.Error;
import com.spotify.dto.Playlist.Playlist;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.spotify.ReqResBuilder.SpecBuilder.getRequestSpec;
import static com.spotify.ReqResBuilder.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PlaylistTest {

    @Test
    public void TC_01_AbleToCreatePlaylist(){
        Playlist playlist = new Playlist();
        playlist.setName("New Playlist 14-12-23 V4");
        playlist.setDescription("New playlist description V4");
        playlist.setPublic(false);

        Response response = PlaylistCLient.createPlaylist(playlist);
        Playlist responsePlaylist = response.as(Playlist.class);

        assertThat(responsePlaylist.getName(), equalTo(playlist.getName()));
        assertThat(responsePlaylist.getDescription(), equalTo(playlist.getDescription()));
        assertThat(responsePlaylist.getPublic(), equalTo(playlist.getPublic()));
    }

    @Test
    public void TC_02_NotBeAbleToCreatePlaylistWithoutName(){
        Playlist playlist = new Playlist();
        playlist.setName(null);
        playlist.setDescription("New playlist description V2");
        playlist.setPublic(false);

        Response response = PlaylistCLient.createPlaylist(playlist);
        Error responseError = response.as(Error.class);


       assertThat(responseError.getInnerError().getMessage(), equalTo("Missing required field: names"));
    }

    @Test
    public void TC_03_BeAbleToGetPlaylistById(){
        Response response = PlaylistCLient.getPlaylistById("6l05zVSnPenlhc0wvFHhv7");
        Playlist responsePlaylist = response.as(Playlist.class);

       assertThat(responsePlaylist.getName(), equalTo("New Playlist 08-12-23"));
       assertThat(responsePlaylist.getDescription(), equalTo("New playlist description"));
       assertThat(responsePlaylist.getPublic(), equalTo(false));
    }

    public void TC_04_BeAbleToUpdatePlaylist(){
        Playlist requestPlaylist = new Playlist();
        requestPlaylist.setName("Updated Playlist Name");
        requestPlaylist.setDescription("Updated playlist description");
        requestPlaylist.setPublic(false);

        String playListId = "0PIoI92tYxdtn04OvYsDpm";
        Response response = PlaylistCLient.updatePlaylistByPlaylistID(playListId, requestPlaylist);
        Playlist responsePlaylist = response.as(Playlist.class);

        // Verify

    }

}
