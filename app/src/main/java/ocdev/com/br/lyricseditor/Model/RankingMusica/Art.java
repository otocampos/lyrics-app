package ocdev.com.br.lyricseditor.Model.RankingMusica;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oto on 01/03/2018.
 */

public class Art implements Parcelable {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("pic_small")
    private String picSmall;
    @SerializedName("pic_medium")
    private String picMedium;

    @SerializedName("week")
    private Week week;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicSmall() {
        return picSmall;
    }

    public void setPicSmall(String picSmall) {
        this.picSmall = picSmall;
    }

    public String getPicMedium() {
        return picMedium;
    }

    public void setPicMedium(String picMedium) {
        this.picMedium = picMedium;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.url);
        dest.writeString(this.picSmall);
        dest.writeString(this.picMedium);
        dest.writeParcelable(this.week, flags);
    }

    public Art() {
    }

    protected Art(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.url = in.readString();
        this.picSmall = in.readString();
        this.picMedium = in.readString();
        this.week = in.readParcelable(Week.class.getClassLoader());
    }

    public static final Creator<Art> CREATOR = new Creator<Art>() {
        @Override
        public Art createFromParcel(Parcel source) {
            return new Art(source);
        }

        @Override
        public Art[] newArray(int size) {
            return new Art[size];
        }
    };
}