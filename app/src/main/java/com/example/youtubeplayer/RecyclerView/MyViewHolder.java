package com.example.youtubeplayer.RecyclerView;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubeplayer.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class MyViewHolder extends RecyclerView.ViewHolder {
    YouTubePlayerView VideoHolder;
    TextView TitleHolder;

    FrameLayout FullscreenView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        VideoHolder = itemView.findViewById(R.id.youTubePlayerView);
//        VideoHolder.setEnableAutomaticInitialization(false);
//        VideoHolder.addFullscreenListener(new FullscreenListener() {
//            @Override
//            public void onEnterFullscreen(@NonNull View fullscreenView, @NonNull Function0<Unit> function0) {
//                VideoHolder.setVisibility(View.GONE);
//                FullscreenView.setVisibility(View.VISIBLE);
//                FullscreenView.addView(fullscreenView);
//            }
//
//            @Override
//            public void onExitFullscreen() {
//                VideoHolder.setVisibility(View.VISIBLE);
//                FullscreenView.setVisibility(View.GONE);
//                FullscreenView.removeAllViews();
//            }
//        });


        TitleHolder = itemView.findViewById(R.id.titleHolder);
        FullscreenView = itemView.findViewById(R.id.FullscreenView);



    }
}
