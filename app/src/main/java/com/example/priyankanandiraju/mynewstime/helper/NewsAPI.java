package com.example.priyankanandiraju.mynewstime.helper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.priyankanandiraju.mynewstime.helper.Constants.BASE_URL;

/**
 * Created by priyankanandiraju on 6/11/17.
 */

public class NewsAPI {

    private static Retrofit mRetrofit = null;

    public static Retrofit getClient() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }
        return mRetrofit;
    }

}
