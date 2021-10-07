package com.petter.portablemusic.usecase.repository;

import com.petter.portablemusic.entity.Song;
import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public interface SongNetworkRepository {
    Observable<List<Song>> fetchSongs();
}
