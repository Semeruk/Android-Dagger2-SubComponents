package com.semeruk.android_dagger2_subcomponents.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.semeruk.android_dagger2_subcomponents.R;
import com.semeruk.android_dagger2_subcomponents.activity.fragment.StorePromocodeFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class StoreActivity extends AppCompatActivity {

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        ButterKnife.bind(this);

        fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content, new StorePromocodeFragment());
        ft.commit();
    }

    @OnClick(R.id.btn_get_promocode)
    public void getPromocode(View view){
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content, new StorePromocodeFragment());
        ft.commit();
    }

    /*public void getCoupon(View view){
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content, new ToCouponFragment());
        ft.commit();
    }*/
}