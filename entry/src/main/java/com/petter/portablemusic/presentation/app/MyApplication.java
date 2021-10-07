package com.petter.portablemusic.presentation.app;

import com.petter.portablemusic.presentation.di.component.ApplicationComponent;
import com.petter.portablemusic.presentation.di.component.DaggerApplicationComponent;
import ohos.aafwk.ability.AbilityPackage;

public class MyApplication extends AbilityPackage {

    private ApplicationComponent component;

    @Override
    public void onInitialize() {
        super.onInitialize();
        component = DaggerApplicationComponent.builder()
                .provideApplication(this)
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
