package com.petter.portablemusic.usecase.usecase;

import com.petter.portablemusic.entity.Song;
import com.petter.portablemusic.usecase.repository.SongNetworkRepository;
import io.reactivex.rxjava3.core.Observable;

import javax.inject.Inject;
import java.util.List;

public class SongUseCase {
    private final SongNetworkRepository songNetworkRepository;

    @Inject
    public SongUseCase(SongNetworkRepository songNetworkRepository) {
        this.songNetworkRepository = songNetworkRepository;
    }

    public Observable<List<Song>> fetchSongs() {
        return this.songNetworkRepository.fetchSongs();
    }
}
