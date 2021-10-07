package com.petter.portablemusic.presentation.ui.presenter;

import com.petter.portablemusic.entity.Song;

import java.util.List;

public interface SongContract {
    interface View {
        void showSongs(List<Song> songs);

        void showError(String message);
    }

    interface Presenter {

        void setView(View view);

        void fetchSongs();

        void unbind();
    }

}
