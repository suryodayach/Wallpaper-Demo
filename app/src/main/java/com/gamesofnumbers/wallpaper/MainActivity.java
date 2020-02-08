package com.gamesofnumbers.wallpaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewWallpaper;
    WallpaperAdapter adapter;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewWallpaper = findViewById(R.id.recycler_view_wallpaper);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL);
        adapter = new WallpaperAdapter();
        recyclerViewWallpaper.setLayoutManager(layoutManager);
        recyclerViewWallpaper.setAdapter(adapter);
        lottieAnimationView = findViewById(R.id.animation_view);
        lottieAnimationView.setVisibility(View.VISIBLE);

        WallpaperViewModel viewModel = new ViewModelProvider(this).get(WallpaperViewModel.class);
        viewModel.getWallpapers().observe(this, new Observer<List<Wallpaper>>() {
            @Override
            public void onChanged(List<Wallpaper> wallpapers) {
                updateUI(wallpapers);
            }
        });

    }

    private void updateUI(List<Wallpaper> wallpapers) {
        adapter.submitList(wallpapers);
        lottieAnimationView.setVisibility(View.GONE);
        recyclerViewWallpaper.setVisibility(View.VISIBLE);

    }
}
