package com.petter.portablemusic.datasource.network.di;

import com.petter.portablemusic.datasource.network.mapper.SongListMapper;
import com.petter.portablemusic.datasource.network.mapper.SongMapper;
import com.petter.portablemusic.datasource.network.model.response.SongResponse;
import com.petter.portablemusic.datasource.network.util.Mapper;
import com.petter.portablemusic.entity.Song;
import dagger.Binds;
import dagger.Module;

import javax.inject.Singleton;
import java.util.List;

@Module
public interface MapperModule {

    @Binds
    @Singleton
    Mapper<SongResponse, Song> provideSongMapper(SongMapper songMapper);

    @Binds
    @Singleton
    Mapper<List<SongResponse>, List<Song>> provideSongListMapper(SongListMapper songListMapper);
}
