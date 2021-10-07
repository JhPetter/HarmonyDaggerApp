package com.petter.portablemusic.presentation.ui.slice.di;

import com.petter.portablemusic.presentation.ui.presenter.SongContract;
import com.petter.portablemusic.presentation.ui.presenter.SongPresenter;
import dagger.Binds;
import dagger.Module;

@Module
public interface PresenterModule {

    @Binds
    SongContract.Presenter providePresenter(SongPresenter songPresenter);
}
