package com.gamesofnumbers.wallpaper;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("getImages")
    Call<List<Wallpaper>> getWallpapers(
    );

}
