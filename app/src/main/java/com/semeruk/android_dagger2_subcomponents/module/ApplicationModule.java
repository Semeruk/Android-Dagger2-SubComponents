package com.semeruk.android_dagger2_subcomponents.module;

import android.app.Application;

import com.semeruk.android_dagger2_subcomponents.component.subcomponent.PromocodeSubComponent;
import com.semeruk.android_dagger2_subcomponents.component.subcomponent.UserActivitySubComponent;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

// Do we need this line?
@Module(subcomponents = { UserActivitySubComponent.class, PromocodeSubComponent.class })
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    // It is the method in charge of providing the instance of the Application class
    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }
}