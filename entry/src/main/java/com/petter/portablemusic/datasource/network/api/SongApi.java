package com.petter.portablemusic.datasource.network.api;

import com.petter.portablemusic.datasource.network.model.response.SongPageResponse;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface SongApi {
    @GET("search?term=salsa&entity=song")
    Observable<SongPageResponse> fetchSongs();
}
