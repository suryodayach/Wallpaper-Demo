package com.gamesofnumbers.wallpaper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private static final String TAG = "Repository";
    private static final String BASE_URL = "https://us-central1-spring-69a53.cloudfunctions.net/";


    private static Repository repository;
    private ApiService apiService;

    public Repository(ApiService apiService) {
        this.apiService = apiService;
    }

    public static Repository getInstance() {

        if (repository == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            repository = new Repository(retrofit.create(ApiService.class));

        }

        return repository;

    }

    public LiveData<List<Wallpaper>> getWallpapers() {
        final MutableLiveData<List<Wallpaper>> wallpapers = new MutableLiveData<>();
        apiService.getWallpapers()
                .enqueue(new Callback<List<Wallpaper>>() {
                    @Override
                    public void onResponse(Call<List<Wallpaper>> call, Response<List<Wallpaper>> response) {
                        if (response.isSuccessful()) {
                          wallpapers.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Wallpaper>> call, Throwable t) {

                    }
                });

        return wallpapers;

    }

}
