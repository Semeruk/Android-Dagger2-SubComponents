package com.semeruk.android_dagger2_subcomponents.component;

import com.semeruk.android_dagger2_subcomponents.component.subcomponent.PromocodeSubComponent;
import com.semeruk.android_dagger2_subcomponents.component.subcomponent.UserActivitySubComponent;
import com.semeruk.android_dagger2_subcomponents.module.ApplicationModule;
import com.semeruk.android_dagger2_subcomponents.module.DataModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton // Parent component
@Component(modules = { DataModule.class, ApplicationModule.class })
public interface ApplicationComponent {

    // Injection targets here
    //void inject(Application application);
    /*void inject(UserActivity activity);
    void inject(UserActivity activity);
    void inject(UserActivity activity);
    ...*/

    UserActivitySubComponent.Builder userActivityBuilder();
    PromocodeSubComponent.Builder promocodeBuilder();
}