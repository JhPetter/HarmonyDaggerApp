package com.petter.portablemusic.presentation.ui.slice;

import com.petter.portablemusic.ResourceTable;
import com.petter.portablemusic.entity.Song;
import com.petter.portablemusic.presentation.app.MyApplication;
import com.petter.portablemusic.presentation.ui.presenter.SongContract;
import com.petter.portablemusic.presentation.ui.presenter.SongContract.View;
import com.petter.portablemusic.presentation.ui.slice.di.DaggerMainSliceComponent;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Text;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

import javax.inject.Inject;
import java.util.List;

public class MainAbilitySlice extends AbilitySlice implements View {

    private static final String TAG = MainAbilitySlice.class.getSimpleName();

    private static final HiLogLabel LABEL_LOG = new HiLogLabel(3, 0xD000F00, TAG);

    @Inject
    SongContract.Presenter presenter;

    private Text textWeather;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        initComponents();
    }

    private void initComponents() {
        DaggerMainSliceComponent.factory().create(((MyApplication) getAbility().getAbilityPackage()).getComponent()).inject(this);
        presenter.setView(this);
        presenter.fetchSongs();
        textWeather = (Text) findComponentById(ResourceTable.Id_textWeather);
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    @Override
    public void showSongs(List<Song> songs) {
        textWeather.setText("Size of songs: " + songs.size());
    }

    @Override
    public void showError(String message) {
        HiLog.error(LABEL_LOG, message);
        textWeather.setText("Error: " + message);
    }

    @Override
    protected void onBackground() {
        super.onBackground();
        presenter.unbind();
    }
}
