package com.example.priyankanandiraju.mynewstime.utilities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by priyankanandiraju on 6/11/17.
 */

public class TopStories implements Parcelable {
    /*
        "status": "OK",
        "copyright": "Copyright (c) 2017 The New York Times Company. All Rights Reserved.",
        "section": "home",
        "last_updated": "2017-06-11T23:52:02-05:00",
        "num_results": 30,
        "results": [...]
     */
    public static final Creator<TopStories> CREATOR = new Creator<TopStories>() {
        @Override
        public TopStories createFromParcel(Parcel in) {
            return new TopStories(in);
        }

        @Override
        public TopStories[] newArray(int size) {
            return new TopStories[size];
        }
    };

    @SerializedName("status")
    private String status;
    @SerializedName("copyright")
    private String copyright;
    @SerializedName("section")
    private String section;
    @SerializedName("last_updated")
    private String last_updated;
    @SerializedName("num_results")
    private String num_results;
    @SerializedName("results")
    private List<Story> storyList = new ArrayList<>();

    protected TopStories(Parcel in) {
        status = in.readString();
        copyright = in.readString();
        section = in.readString();
        last_updated = in.readString();
        num_results = in.readString();
        storyList = in.createTypedArrayList(Story.CREATOR);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public String getNum_results() {
        return num_results;
    }

    public void setNum_results(String num_results) {
        this.num_results = num_results;
    }

    public List<Story> getStoryList() {
        return storyList;
    }

    public void setStoryList(List<Story> storyList) {
        this.storyList = storyList;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(copyright);
        dest.writeString(section);
        dest.writeString(last_updated);
        dest.writeString(num_results);
        dest.writeTypedList(storyList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "TopStories{" +
                "status='" + status + '\'' +
                ", copyright='" + copyright + '\'' +
                ", section='" + section + '\'' +
                ", last_updated='" + last_updated + '\'' +
                ", num_results='" + num_results + '\'' +
                ", storyList=" + storyList +
                '}';
    }
}
