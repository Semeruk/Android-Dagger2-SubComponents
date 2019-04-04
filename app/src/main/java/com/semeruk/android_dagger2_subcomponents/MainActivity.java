package com.semeruk.android_dagger2_subcomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.semeruk.android_dagger2_subcomponents.module.MainActivityModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDagger();
    }

    private void initDagger() {
        // Get ApplicationComponent
        ((CustomApplication) getApplication()).getApplicationComponent()
                // Get Builder as an interface
                .mainActivityBuilder()
                // Pass activity module
                .mainActivityModule(new MainActivityModule(this))
                // Then build the component
                .build()
                // After inject this activity to get inject instances from modules
                .inject(this);
    }
}