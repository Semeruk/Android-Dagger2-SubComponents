package com.semeruk.android_dagger2_subcomponents.component.subcomponent;

import com.semeruk.android_dagger2_subcomponents.activity.fragment.StorePromocodeFragment;
import com.semeruk.android_dagger2_subcomponents.module.PromocodeModule;
import com.semeruk.android_dagger2_subcomponents.scope.PromocodeScope;

import dagger.Subcomponent;

@PromocodeScope
@Subcomponent(modules = PromocodeModule.class)
public interface PromocodeSubComponent {

    @Subcomponent.Builder
    interface Builder {
        PromocodeSubComponent.Builder promocodeModule(PromocodeModule module);
        PromocodeSubComponent build();
    }

    void inject(StorePromocodeFragment fragment);
}