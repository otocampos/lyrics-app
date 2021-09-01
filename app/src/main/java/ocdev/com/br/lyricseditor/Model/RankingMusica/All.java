package ocdev.com.br.lyricseditor.Model.RankingMusica;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oto on 01/03/2018.
 */

public class All implements Parcelable {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("uniques")
    private String uniques;
    @SerializedName("views")
    private String views;
    @SerializedName("rank")
    private String rank;
    @SerializedName("art")
    private Art art;
    @SerializedName("albd")
    private String albd;
    @SerializedName("alby")
    private String alby;
    @SerializedName("alburl")
    private String alburl;
    @SerializedName("pic_small")
    private String picSmall;
    @SerializedName("pic_medium")
    private String picMedium;


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

    public String getUniques() {
        return uniques;
    }

    public void setUniques(String uniques) {
        this.uniques = uniques;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Art getArt() {
        return art;
    }

    public void setArt(Art art) {
        this.art = art;
    }

    public String getAlbd() {
        return albd;
    }

    public void setAlbd(String albd) {
        this.albd = albd;
    }

    public String getAlby() {
        return alby;
    }

    public void setAlby(String alby) {
        this.alby = alby;
    }

    public String getAlburl() {
        return alburl;
    }

    public void setAlburl(String alburl) {
        this.alburl = alburl;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.url);
        dest.writeString(this.uniques);
        dest.writeString(this.views);
        dest.writeString(this.rank);
        dest.writeParcelable(this.art, flags);
        dest.writeString(this.albd);
        dest.writeString(this.alby);
        dest.writeString(this.alburl);
        dest.writeString(this.picSmall);
        dest.writeString(this.picMedium);
    }

    public All() {
    }

    protected All(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.url = in.readString();
        this.uniques = in.readString();
        this.views = in.readString();
        this.rank = in.readString();
        this.art = in.readParcelable(Art.class.getClassLoader());
        this.albd = in.readString();
        this.alby = in.readString();
        this.alburl = in.readString();
        this.picSmall = in.readString();
        this.picMedium = in.readString();
    }

    public static final Creator<All> CREATOR = new Creator<All>() {
        @Override
        public All createFromParcel(Parcel source) {
            return new All(source);
        }

        @Override
        public All[] newArray(int size) {
            return new All[size];
        }
    };
}
