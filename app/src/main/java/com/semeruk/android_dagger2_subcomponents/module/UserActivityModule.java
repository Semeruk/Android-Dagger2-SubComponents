package com.semeruk.android_dagger2_subcomponents.module;

import android.app.Application;
import android.widget.ArrayAdapter;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.semeruk.android_dagger2_subcomponents.activity.UserActivity;
import com.semeruk.android_dagger2_subcomponents.model.Repository;
import com.semeruk.android_dagger2_subcomponents.scope.UserActivityScope;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Module
public class UserActivityModule {

    private final UserActivity mActivity;

    // Must be instantiated with an activity
    public UserActivityModule(UserActivity activity) {
        mActivity = activity;
    }

    @Provides
    @UserActivityScope
    ArrayAdapter provideMainListAdapter() {
        return new ArrayAdapter<String>(mActivity, android.R.layout.list_content);
    }

    @Provides
    @UserActivityScope
    String provideUrl() {
        return "https://api.github.com";
    }

    public interface ApiInterface {
        @GET("/users/{user}/repos")
        Call<List<Repository>> getRepository(@Path("user") String userName);
    }

    @Provides
    @UserActivityScope
    ApiInterface provideApiInterface(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }

    @Provides
    @UserActivityScope
    Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides
    @UserActivityScope
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @UserActivityScope
    OkHttpClient provideOkHttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        return client.build();
    }

    @Provides
    @UserActivityScope
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient, String url) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(url)
                .client(okHttpClient)
                .build();
    }

}