package com.semeruk.android_dagger2_subcomponents.component.subcomponent;

import com.semeruk.android_dagger2_subcomponents.activity.UserActivity;
import com.semeruk.android_dagger2_subcomponents.module.UserActivityModule;
import com.semeruk.android_dagger2_subcomponents.scope.UserActivityScope;

import dagger.Subcomponent;

@UserActivityScope
@Subcomponent(modules = { UserActivityModule.class })
public interface UserActivitySubComponent {
    void inject(UserActivity activity);

    @Subcomponent.Builder
    interface Builder {
        Builder userActivityModule(UserActivityModule module);
        UserActivitySubComponent build();
    }
}