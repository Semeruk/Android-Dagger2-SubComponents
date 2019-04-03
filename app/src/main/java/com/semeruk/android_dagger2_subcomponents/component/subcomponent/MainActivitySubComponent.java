package com.semeruk.android_dagger2_subcomponents.component.subcomponent;

import com.semeruk.android_dagger2_subcomponents.MainActivity;
import com.semeruk.android_dagger2_subcomponents.module.MainActivityModule;
import com.semeruk.android_dagger2_subcomponents.scope.MainActivityScope;

import dagger.Subcomponent;

@MainActivityScope
@Subcomponent(modules = { MainActivityModule.class })
public interface MainActivitySubComponent {
    void inject(MainActivity activity);

    @Subcomponent.Builder
    interface Builder {
        Builder mainActivityModule(MainActivityModule module);
        MainActivitySubComponent build();
    }
}