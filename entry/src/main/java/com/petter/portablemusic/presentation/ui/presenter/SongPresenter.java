package com.petter.portablemusic.presentation.ui.presenter;

import com.petter.portablemusic.presentation.ui.presenter.SongContract.Presenter;
import com.petter.portablemusic.presentation.ui.presenter.SongContract.View;
import com.petter.portablemusic.presentation.util.HarmonySchedulers;
import com.petter.portablemusic.usecase.usecase.SongUseCase;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import javax.inject.Inject;

public class SongPresenter implements Presenter {
    private View view;
    private final SongUseCase songUseCase;
    private final CompositeDisposable compositeDisposable;


    @Inject
    public SongPresenter(SongUseCase songUseCase) {
        this.songUseCase = songUseCase;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void fetchSongs() {
        Disposable single = songUseCase.fetchSongs()
                .subscribeOn(Schedulers.io())
                .observeOn(HarmonySchedulers.mainThread())
                .subscribe(view::showSongs, error -> view.showError(error.getMessage()));
        compositeDisposable.add(single);
    }

    @Override
    public void unbind() {
        compositeDisposable.dispose();
    }

}
