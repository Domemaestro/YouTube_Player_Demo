package com.example.youtubeplayer.API;

import com.example.youtubeplayer.Models.VideoDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    @GET("search")
    Call<VideoDetails> getVideoDetails(@Query("key") String key,
                                       @Query("channelId") String channelId,
                                       @Query("part") String part,
                                       @Query("maxResults") String maxResult);
}
