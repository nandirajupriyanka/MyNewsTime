package com.example.priyankanandiraju.mynewstime.helper;

import com.example.priyankanandiraju.mynewstime.utilities.TopStories;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.priyankanandiraju.mynewstime.helper.Constants.API_KEY_PARAM;
import static com.example.priyankanandiraju.mynewstime.helper.Constants.TOP_STORIES;

/**
 * Created by priyankanandiraju on 6/11/17.
 */

public interface NewsAPIService {
    @GET(TOP_STORIES)
    Call<TopStories> getTopRatedMovies(@Query(API_KEY_PARAM) String apiKey);
}
