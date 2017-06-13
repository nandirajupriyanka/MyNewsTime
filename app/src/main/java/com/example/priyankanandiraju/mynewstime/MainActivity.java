package com.example.priyankanandiraju.mynewstime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.priyankanandiraju.mynewstime.helper.NewsAPI;
import com.example.priyankanandiraju.mynewstime.helper.NewsAPIService;
import com.example.priyankanandiraju.mynewstime.utilities.Story;
import com.example.priyankanandiraju.mynewstime.utilities.TopStories;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.rv_top_stories)
    RecyclerView rvTopStories;
    @BindView(R.id.tv_copyright)
    TextView tvCopyright;
    @BindView(R.id.tv_result)
    TextView tvResult;
    private NewsAPIService mNewsAPIService;
    private TopStoriesAdapter mTopStoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        rvTopStories.setHasFixedSize(true);
        rvTopStories.setLayoutManager(new LinearLayoutManager(this));
        mTopStoriesAdapter = new TopStoriesAdapter(this, new ArrayList<Story>());
        rvTopStories.setAdapter(mTopStoriesAdapter);
        createNewsAPI();
        fetchTopStories();
    }

    private void createNewsAPI() {
        Retrofit retrofit = NewsAPI.getClient();
        mNewsAPIService = retrofit.create(NewsAPIService.class);
    }

    private void fetchTopStories() {
        Call<TopStories> topStoriesCall = mNewsAPIService.getTopRatedMovies(BuildConfig.NY_TIMES_API_KEY);
        topStoriesCall.enqueue(new Callback<TopStories>() {
            @Override
            public void onResponse(Call<TopStories> call, Response<TopStories> response) {
                Log.v(TAG, "onResponse " + response.body().toString());
                TopStories topStories = response.body();
                tvCopyright.setText(topStories.getCopyright());
                tvResult.setText(topStories.getNum_results());
                mTopStoriesAdapter.setNewsData(topStories.getStoryList());
            }

            @Override
            public void onFailure(Call<TopStories> call, Throwable t) {
                Log.e(TAG, "onFailure " + t.toString());
            }
        });
    }
}
