package com.semeruk.android_dagger2_subcomponents.component;

import android.app.Application;

import com.semeruk.android_dagger2_subcomponents.component.subcomponent.MainActivitySubComponent;
import com.semeruk.android_dagger2_subcomponents.module.ApplicationModule;
import com.semeruk.android_dagger2_subcomponents.module.DataModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton // Parent component
@Component(modules = { DataModule.class, ApplicationModule.class })
public interface ApplicationComponent {

    // Injection targets here
    //void inject(Application application);
    /*void inject(MainActivity activity);
    void inject(MainActivity activity);
    void inject(MainActivity activity);
    ...*/

    MainActivitySubComponent.Builder mainActivityBuilder();
}