package com.petter.portablemusic.datasource.network.mapper;

import com.petter.portablemusic.datasource.network.model.response.SongResponse;
import com.petter.portablemusic.datasource.network.util.Mapper;
import com.petter.portablemusic.entity.Song;

import javax.inject.Inject;

public class SongMapper implements Mapper<SongResponse, Song> {
    @Inject
    public SongMapper() {
    }

    @Override
    public Song invoke(SongResponse input) {
        return new Song(input.getId(), input.getArtistName(), input.getName(), input.getTrackPreview(), input.getImage());
    }
}
