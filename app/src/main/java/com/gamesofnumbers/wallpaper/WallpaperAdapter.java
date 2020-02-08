package com.gamesofnumbers.wallpaper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class WallpaperAdapter extends ListAdapter<Wallpaper, WallpaperAdapter.WallpaperHolder> {

    List<Wallpaper> wallpapers = new ArrayList<>();

    protected WallpaperAdapter() {
        super(DIFF_CALLBACK);
    }

    private static DiffUtil.ItemCallback<Wallpaper> DIFF_CALLBACK = new DiffUtil.ItemCallback<Wallpaper>() {
        @Override
        public boolean areItemsTheSame(@NonNull Wallpaper oldItem, @NonNull Wallpaper newItem) {
            return oldItem.getId().equals(newItem.getId())
                    || oldItem.getName().equals(newItem.getName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Wallpaper oldItem, @NonNull Wallpaper newItem) {
            return oldItem.getId().equals(newItem.getId())
                    || oldItem.getName().equals(newItem.getName());
        }
    };

    @NonNull
    @Override
    public WallpaperHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wallpaper_item, parent, false);
        return new WallpaperHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperHolder holder, int position) {

        final Wallpaper wallpaper = getItem(position);
        holder.textViewName.setText(wallpaper.getDescription());
        Picasso.get().load(wallpaper.getThumbUrl()).into(holder.imageViewWallpaper);

    }

    public class WallpaperHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        ImageView imageViewWallpaper;

        public WallpaperHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_wallpaper);
            imageViewWallpaper = itemView.findViewById(R.id.image_view_wallpaper);
        }
    }
}
