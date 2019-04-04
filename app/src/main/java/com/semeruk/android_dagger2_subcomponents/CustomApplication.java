package com.semeruk.android_dagger2_subcomponents;

import android.app.Application;

import com.semeruk.android_dagger2_subcomponents.component.ApplicationComponent;
import com.semeruk.android_dagger2_subcomponents.component.DaggerApplicationComponent;
import com.semeruk.android_dagger2_subcomponents.module.ApplicationModule;

public class CustomApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                // List of modules that are part of this component
                // where we need to pass Application class
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}