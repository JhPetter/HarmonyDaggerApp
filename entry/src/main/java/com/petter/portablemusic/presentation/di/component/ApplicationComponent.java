package com.petter.portablemusic.presentation.di.component;

import com.petter.portablemusic.datasource.network.api.SongApi;
import com.petter.portablemusic.datasource.network.di.RetrofitModule;
import com.petter.portablemusic.presentation.app.MyApplication;
import com.petter.portablemusic.presentation.di.module.ApplicationModule;
import dagger.BindsInstance;
import dagger.Component;
import ohos.aafwk.ability.AbilityPackage;

import javax.inject.Singleton;

@Singleton
@Component(modules = {ApplicationModule.class, RetrofitModule.class,})
public interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder provideApplication(AbilityPackage abilityPackage);

        ApplicationComponent build();
    }

    SongApi provideSongApi();

    void inject(MyApplication myApplication);
}
