package com.petter.portablemusic.datasource.network.mapper;

import com.petter.portablemusic.datasource.network.model.response.SongResponse;
import com.petter.portablemusic.datasource.network.util.Mapper;
import com.petter.portablemusic.entity.Song;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class SongListMapper implements Mapper<List<SongResponse>, List<Song>> {
    private final SongMapper songMapper;

    @Inject
    public SongListMapper(SongMapper songMapper) {
        this.songMapper = songMapper;
    }

    @Override
    public List<Song> invoke(List<SongResponse> songResponses) {
        List<Song> songs = new ArrayList<>();
        for (SongResponse songResponse : songResponses) {
            songs.add(songMapper.invoke(songResponse));
        }
        return songs;
    }
}
