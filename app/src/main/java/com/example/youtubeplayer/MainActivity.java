package com.example.youtubeplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.youtubeplayer.API.SingletonRetrofitObject;
import com.example.youtubeplayer.Models.Items;
import com.example.youtubeplayer.Models.VideoDetails;
import com.example.youtubeplayer.RecyclerView.Adapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        dropApiCall();
    }

    private void dropApiCall() {

        Call<VideoDetails> videoDetailsCall = SingletonRetrofitObject.getmInstance().getAPI().getVideoDetails(
                getString(R.string.youtubeAPI),
                getString(R.string.NCS_Channel_Id),
                "snippet",
                "50"
        );

        videoDetailsCall.enqueue(new Callback<VideoDetails>() {
            @Override
            public void onResponse(Call<VideoDetails> call, Response<VideoDetails> response) {
                setRecyclerView(response.body().getItems());
            }

            @Override
            public void onFailure(Call<VideoDetails> call, Throwable t) {

            }
        });
    }

    private void setRecyclerView(Items[] items) {
        Adapter myAdapter = new Adapter(this,items);
        recyclerView.setAdapter(myAdapter);
    }
}