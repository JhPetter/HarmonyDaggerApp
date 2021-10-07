package com.petter.portablemusic.datasource.network.di;

import com.petter.portablemusic.datasource.network.source.SongNetwork;
import com.petter.portablemusic.usecase.repository.SongNetworkRepository;
import dagger.Binds;
import dagger.Module;

@Module
public interface NetworkModule {
    @Binds
    SongNetworkRepository provideWeatherNetwork(SongNetwork songNetwork);
}
