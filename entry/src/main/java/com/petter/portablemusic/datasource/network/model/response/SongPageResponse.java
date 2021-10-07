package com.petter.portablemusic.datasource.network.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SongPageResponse {
    @SerializedName("resultCount")
    private String resultCount;
    @SerializedName("results")
    private List<SongResponse> songs;

    public SongPageResponse() {
    }

    public SongPageResponse(String resultCount, List<SongResponse> songs) {
        this.resultCount = resultCount;
        this.songs = songs;
    }

    public String getResultCount() {
        return resultCount;
    }

    public List<SongResponse> getSongs() {
        return songs;
    }
}
