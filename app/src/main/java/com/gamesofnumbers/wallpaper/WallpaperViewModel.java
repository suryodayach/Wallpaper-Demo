package com.gamesofnumbers.wallpaper;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WallpaperViewModel extends AndroidViewModel {

    private static final String TAG = "WallpaperViewModel";
    LiveData<List<Wallpaper>> wallpapers;
    Repository repository;


    public WallpaperViewModel(@NonNull Application application) {
        super(application);

        repository = Repository.getInstance();

        wallpapers = repository.getWallpapers();

    }

    public LiveData<List<Wallpaper>> getWallpapers() {
        return wallpapers;
    }

}
