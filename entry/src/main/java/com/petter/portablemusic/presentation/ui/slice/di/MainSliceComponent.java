package com.petter.portablemusic.presentation.ui.slice.di;

import com.petter.portablemusic.datasource.network.di.MapperModule;
import com.petter.portablemusic.datasource.network.di.NetworkModule;
import com.petter.portablemusic.presentation.di.component.ApplicationComponent;
import com.petter.portablemusic.presentation.di.scope.AbilityScope;
import com.petter.portablemusic.presentation.ui.slice.MainAbilitySlice;
import dagger.Component;

@AbilityScope
@Component(dependencies = ApplicationComponent.class, modules = {PresenterModule.class, NetworkModule.class, MapperModule.class})
public interface MainSliceComponent {
    @Component.Factory
    interface Factory {
        MainSliceComponent create(ApplicationComponent applicationComponent);
    }

    void inject(MainAbilitySlice mainAbilitySlice);
}
