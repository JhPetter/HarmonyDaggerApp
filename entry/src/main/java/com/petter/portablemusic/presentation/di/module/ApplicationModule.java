package com.petter.portablemusic.presentation.di.module;

import com.petter.portablemusic.BuildConfig;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;

@Module
public class ApplicationModule {

    @Provides
    @Named("base_url")
    String provideBaseUrl() {
        return BuildConfig.BASE_URL;
    }
}
