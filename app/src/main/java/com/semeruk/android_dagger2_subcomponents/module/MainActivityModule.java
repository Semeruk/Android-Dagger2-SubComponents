package com.semeruk.android_dagger2_subcomponents.module;

import android.widget.ArrayAdapter;

import com.semeruk.android_dagger2_subcomponents.MainActivity;
import com.semeruk.android_dagger2_subcomponents.scope.MainActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    private final MainActivity mActivity;

    // Must be instantiated with an activity
    public MainActivityModule(MainActivity activity) {
        mActivity = activity;
    }

    @Provides
    @MainActivityScope
    public ArrayAdapter provideMainListAdapter() {
        return new ArrayAdapter<String>(mActivity, android.R.layout.list_content);
    }
}