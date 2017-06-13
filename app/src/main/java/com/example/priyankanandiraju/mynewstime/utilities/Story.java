package com.example.priyankanandiraju.mynewstime.utilities;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by priyankanandiraju on 6/11/17.
 */

public class Story implements Parcelable {

    public static final Creator<Story> CREATOR = new Creator<Story>() {
        @Override
        public Story createFromParcel(Parcel in) {
            return new Story(in);
        }

        @Override
        public Story[] newArray(int size) {
            return new Story[size];
        }
    };
    @SerializedName("section")
    private String section;
    @SerializedName("title")
    private String title;
    @SerializedName("abstract")
    private String abstractStr;
    @SerializedName("url")
    private String url;
    @SerializedName("byline")
    private String byline;
    @SerializedName("item_type")
    private String item_type;
    @SerializedName("updated_date")
    private String updated_date;
    @SerializedName("created_date")
    private String created_date;
    @SerializedName("published_date")
    private String published_date;
    @SerializedName("material_type_facet")
    private String material_type_facet;
    @SerializedName("kicker")
    private String kicker;
    @SerializedName("multimedia")
    private List<Multimedia> multimediaList = new ArrayList<>();

    protected Story(Parcel in) {
        section = in.readString();
        title = in.readString();
        abstractStr = in.readString();
        url = in.readString();
        byline = in.readString();
        item_type = in.readString();
        updated_date = in.readString();
        created_date = in.readString();
        published_date = in.readString();
        material_type_facet = in.readString();
        kicker = in.readString();
        multimediaList = in.createTypedArrayList(Multimedia.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(section);
        dest.writeString(title);
        dest.writeString(abstractStr);
        dest.writeString(url);
        dest.writeString(byline);
        dest.writeString(item_type);
        dest.writeString(updated_date);
        dest.writeString(created_date);
        dest.writeString(published_date);
        dest.writeString(material_type_facet);
        dest.writeString(kicker);
        dest.writeTypedList(multimediaList);
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractStr() {
        return abstractStr;
    }

    public void setAbstractStr(String abstractStr) {
        this.abstractStr = abstractStr;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getMaterial_type_facet() {
        return material_type_facet;
    }

    public void setMaterial_type_facet(String material_type_facet) {
        this.material_type_facet = material_type_facet;
    }

    public String getKicker() {
        return kicker;
    }

    public void setKicker(String kicker) {
        this.kicker = kicker;
    }

    @Nullable
    public List<Multimedia> getMultimediaList() {
        return multimediaList;
    }

    public void setMultimediaList(List<Multimedia> multimediaList) {
        this.multimediaList = multimediaList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "Story{" +
                "section='" + section + '\'' +
                ", title='" + title + '\'' +
                ", abstractStr='" + abstractStr + '\'' +
                ", url='" + url + '\'' +
                ", byline='" + byline + '\'' +
                ", item_type='" + item_type + '\'' +
                ", updated_date='" + updated_date + '\'' +
                ", created_date='" + created_date + '\'' +
                ", published_date='" + published_date + '\'' +
                ", material_type_facet='" + material_type_facet + '\'' +
                ", kicker='" + kicker + '\'' +
                ", multimediaList=" + multimediaList +
                '}';
    }
}
