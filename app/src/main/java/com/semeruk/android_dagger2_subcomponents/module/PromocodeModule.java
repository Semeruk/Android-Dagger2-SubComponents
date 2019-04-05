package com.semeruk.android_dagger2_subcomponents.module;

import com.semeruk.android_dagger2_subcomponents.model.Repository;
import com.semeruk.android_dagger2_subcomponents.scope.PromocodeScope;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Module
public class PromocodeModule {

    public interface ApiInterface {
        // Use the same path for testing purpose
        @GET("/users/{user}/repos")
        Call<List<Repository>> getRepository(@Path("user") String userName);
    }

    @PromocodeScope
    @Provides
    ApiInterface getApiClient(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }
}