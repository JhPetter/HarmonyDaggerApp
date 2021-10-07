package com.petter.portablemusic.datasource.network.source;

import com.petter.portablemusic.datasource.network.api.SongApi;
import com.petter.portablemusic.datasource.network.mapper.SongListMapper;
import com.petter.portablemusic.entity.Song;
import com.petter.portablemusic.usecase.repository.SongNetworkRepository;
import io.reactivex.rxjava3.core.Observable;

import javax.inject.Inject;
import java.util.List;

public class SongNetwork implements SongNetworkRepository {

    private final SongApi songApi;
    private final SongListMapper songListMapper;

    @Inject
    public SongNetwork(SongApi songApi, SongListMapper songListMapper) {
        this.songApi = songApi;
        this.songListMapper = songListMapper;
    }

    @Override
    public Observable<List<Song>> fetchSongs() {
        return songApi.fetchSongs().map(songPageResponse -> songListMapper.invoke(songPageResponse.getSongs()));
    }
}
