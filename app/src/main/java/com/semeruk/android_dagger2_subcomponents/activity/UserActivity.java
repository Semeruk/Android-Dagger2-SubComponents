package com.semeruk.android_dagger2_subcomponents.activity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.semeruk.android_dagger2_subcomponents.CustomApplication;
import com.semeruk.android_dagger2_subcomponents.R;
import com.semeruk.android_dagger2_subcomponents.component.subcomponent.UserActivitySubComponent;
import com.semeruk.android_dagger2_subcomponents.model.Repository;
import com.semeruk.android_dagger2_subcomponents.module.UserActivityModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserActivity extends AppCompatActivity {

    // Variables should not be private
    // Inject via Dagger
    @Inject
    Retrofit mRetrofit;
    @Inject
    UserActivityModule.ApiInterface mApiInterface;

    // Bind views
    @BindView(R.id.tv_response)
    TextView tvResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initDagger();
    }

    private void initDagger() {
        // Get ApplicationComponent
        UserActivitySubComponent userActivitySubComponent = ((CustomApplication) getApplication()).getApplicationComponent()
                // Get Builder as an interface
                .userActivityBuilder()
                // Pass activity module
                .userActivityModule(new UserActivityModule(this))
                // Then build the component
                .build();

        // And now just inject this activity to get inject instances from modules
        userActivitySubComponent.inject(this);

        // OR

        // If we don't need Dagger initialization in the Application class
        // (for instance to pass 'this' into application module constructor)
        // we can use just this approach:
        // DaggerApplicationComponent.create().mainActivityBuilder().build().inject(this);
    }

    @OnClick(R.id.fab)
    public void execRequest(View view) {
        Call<List<Repository>> call = mApiInterface.getRepository("codepath");
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
        });
    }
}