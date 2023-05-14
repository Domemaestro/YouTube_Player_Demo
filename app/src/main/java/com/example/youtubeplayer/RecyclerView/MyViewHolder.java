package com.example.youtubeplayer.RecyclerView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubeplayer.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    YouTubePlayerView VideoHolder;
    TextView TitleHolder;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        VideoHolder = itemView.findViewById(R.id.youTubePlayerView);
        TitleHolder = itemView.findViewById(R.id.titleHolder);

    }
}
