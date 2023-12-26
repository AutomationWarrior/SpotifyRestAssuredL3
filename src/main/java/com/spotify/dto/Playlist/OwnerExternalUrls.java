
package com.spotify.dto.Playlist;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class OwnerExternalUrls {

    @JsonProperty("spotify")
    private String spotify;

    @JsonProperty("spotify")
    public String getSpotify() {
        return spotify;
    }

    @JsonProperty("spotify")
    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }


}
