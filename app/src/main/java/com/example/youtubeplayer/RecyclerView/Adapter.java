package com.example.youtubeplayer.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubeplayer.Models.Items;
import com.example.youtubeplayer.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class Adapter extends RecyclerView.Adapter<MyViewHolder> {

    public Adapter(Context context, Items[] items) {
        this.context = context;
        this.items = items;
    }

    Context context;
    Items[] items;

    IFramePlayerOptions iFramePlayerOptions;
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_rc,parent,false);

       iFramePlayerOptions = new IFramePlayerOptions.Builder().controls(1).fullscreen(1).build();

        return new MyViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.TitleHolder.setText(items[position]
                .getSnippet()
                .getTitle());

//        holder.VideoHolder.getYouTubePlayerWhenReady(youTubePlayer -> youTubePlayer.cueVideo(items[holder.getAdapterPosition()].getId().getVideoId(),0f));
        holder.VideoHolder.initialize(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                youTubePlayer.cueVideo(items[holder.getAdapterPosition()].getId().getVideoId(),0f);
            }
        },iFramePlayerOptions);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }
}
