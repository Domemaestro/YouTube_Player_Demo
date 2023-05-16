package com.example.youtubeplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class FullScreen extends AppCompatActivity {

    YouTubePlayerView fullScreenView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        fullScreenView = findViewById(R.id.fullScreenPlayer);
        String VideoId = getIntent().getStringExtra("VideoId");
        fullScreenView.getYouTubePlayerWhenReady(youTubePlayer -> youTubePlayer.cueVideo(VideoId,0f));


    }
}