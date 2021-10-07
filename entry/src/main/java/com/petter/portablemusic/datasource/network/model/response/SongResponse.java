package com.petter.portablemusic.datasource.network.model.response;

import com.google.gson.annotations.SerializedName;

public class SongResponse {
    @SerializedName("trackId")
    private Long id;
    @SerializedName("artistName")
    private String artistName;
    @SerializedName("collectionName")
    private String name;
    @SerializedName("previewUrl")
    private String trackPreview;
    @SerializedName("artworkUrl100")
    private String image;

    public SongResponse() {
    }

    public SongResponse(Long id, String artistName, String name, String trackPreview, String image) {
        this.id = id;
        this.artistName = artistName;
        this.name = name;
        this.trackPreview = trackPreview;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getName() {
        return name;
    }

    public String getTrackPreview() {
        return trackPreview;
    }

    public String getImage() {
        return image;
    }
}
