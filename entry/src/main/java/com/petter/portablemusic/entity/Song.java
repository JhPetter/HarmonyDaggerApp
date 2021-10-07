package com.petter.portablemusic.entity;

public class Song {
    private Long id;
    private String artistName;
    private String name;
    private String trackPreview;
    private String image;

    public Song() {
    }

    public Song(Long id, String artistName, String name, String trackPreview, String image) {
        this.id = id;
        this.artistName = artistName;
        this.name = name;
        this.trackPreview = trackPreview;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrackPreview() {
        return trackPreview;
    }

    public void setTrackPreview(String trackPreview) {
        this.trackPreview = trackPreview;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
