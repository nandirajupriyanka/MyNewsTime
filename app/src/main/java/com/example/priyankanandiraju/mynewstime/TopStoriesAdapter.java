package com.example.priyankanandiraju.mynewstime;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.priyankanandiraju.mynewstime.utilities.Story;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by priyankanandiraju on 6/12/17.
 */

class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.TopStoriesHolder> {
    private final Context mContext;
    private List<Story> mTopStoriesList = new ArrayList<>();

    public TopStoriesAdapter(Context context, List<Story> topStoriesList) {
        mContext = context;
        mTopStoriesList = topStoriesList;
    }

    @Override
    public TopStoriesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_story, parent, false);
        return new TopStoriesHolder(view);
    }

    @Override
    public void onBindViewHolder(TopStoriesHolder holder, int position) {
        Story currentStory = mTopStoriesList.get(position);
        if (currentStory.getMultimediaList() != null && currentStory.getMultimediaList().size() > 0) {
            String imageUrl = currentStory.getMultimediaList().get(0).getUrl();
            Glide.with(mContext)
                    .load(imageUrl)
                    .into(holder.ivStory);
        }

        holder.tvTitle.setText(currentStory.getTitle());
        holder.tvDescription.setText(currentStory.getAbstractStr());
        holder.tvPublishedDate.setText(currentStory.getPublished_date());
    }

    @Override
    public int getItemCount() {
        return mTopStoriesList.size();
    }

    public void setNewsData(List<Story> topStories) {
        mTopStoriesList.clear();
        mTopStoriesList.addAll(topStories);
    }

    public class TopStoriesHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_story)
        ImageView ivStory;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_desc)
        TextView tvDescription;
        @BindView(R.id.tv_published_date)
        TextView tvPublishedDate;

        public TopStoriesHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
