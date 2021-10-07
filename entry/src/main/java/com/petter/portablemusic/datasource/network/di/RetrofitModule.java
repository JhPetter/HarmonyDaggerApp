package com.petter.portablemusic.datasource.network.di;

import com.petter.portablemusic.datasource.network.api.SongApi;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Named;
import java.util.concurrent.TimeUnit;

@Module
public class RetrofitModule {
    @Provides
    OkHttpClient provideClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    @Provides
    Retrofit provideRetrofit(@Named("base_url") String baseURL, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    @Provides
    SongApi provideSongApi(Retrofit retrofit) {
        return retrofit.create(SongApi.class);
    }
}
