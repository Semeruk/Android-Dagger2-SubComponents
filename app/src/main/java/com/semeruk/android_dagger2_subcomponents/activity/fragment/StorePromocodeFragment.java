package com.semeruk.android_dagger2_subcomponents.activity.fragment;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.semeruk.android_dagger2_subcomponents.CustomApplication;
import com.semeruk.android_dagger2_subcomponents.R;
import com.semeruk.android_dagger2_subcomponents.model.Repository;
import com.semeruk.android_dagger2_subcomponents.module.PromocodeModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class StorePromocodeFragment extends Fragment {

    @Inject
    PromocodeModule.ApiInterface mApiInterface;

    public StorePromocodeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        initDagger();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store_promocode, container, false);
    }

    private void initDagger() {

        ((CustomApplication) getActivity().getApplication())
                .getApplicationComponent()
                .promocodeBuilder()
                .build()
                .inject(this);
    }

    @OnClick(R.id.fab)
    public void execRequest(View view) {
        /*Call<List<Repository>> call = mApiInterface.getRepository("codepath");
        call.enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {

                if (response.isSuccessful()) {

                    List<Repository> repositoryList = response.body();

                    StringBuilder stringBuilder = new StringBuilder();

                    for (Repository repository : repositoryList) {
                        stringBuilder.append(repository.toString() + "\n\n");
                    }

                    tvResponse.setText(stringBuilder.toString());

                    //Log.i("DEBUG", response.body().toString());
                    Snackbar.make(view,"Data retrieved", Snackbar.LENGTH_LONG)
                            .setAction("Action",null).show();
                } else {
                    Log.e("ERROR", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
            }
        });*/
    }
}