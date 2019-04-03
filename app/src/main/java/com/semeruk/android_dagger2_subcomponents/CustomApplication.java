package com.semeruk.android_dagger2_subcomponents;

import android.app.Application;

import com.semeruk.android_dagger2_subcomponents.component.DaggerApplicationComponent;
import com.semeruk.android_dagger2_subcomponents.module.ApplicationModule;

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}