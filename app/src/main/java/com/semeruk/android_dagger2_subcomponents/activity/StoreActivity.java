package com.semeruk.android_dagger2_subcomponents.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.semeruk.android_dagger2_subcomponents.R;

public class StoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
    }
}