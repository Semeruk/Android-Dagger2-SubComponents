package com.semeruk.android_dagger2_subcomponents.activity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.semeruk.android_dagger2_subcomponents.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StorePromocodeFragment extends Fragment {


    public StorePromocodeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store_promocode, container, false);
    }

}
