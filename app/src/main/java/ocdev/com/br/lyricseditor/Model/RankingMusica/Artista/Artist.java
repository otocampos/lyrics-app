package ocdev.com.br.lyricseditor.Model.RankingMusica.Artista;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Oto on 07/03/2018.
 */

public class Artist implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("pic_small")
    @Expose
    private String picSmall;
    @SerializedName("pic_medium")
    @Expose
    private String picMedium;
    @SerializedName("rank")
    @Expose
    private Rank rank;
    @SerializedName("genre")
    @Expose
    private List<Genre> genre = null;
    @SerializedName("toplyrics")
    @Expose
    private TopLyrics toplyrics;
    @SerializedName("lyrics")
    @Expose
    private Lyrics lyrics;
    @SerializedName("albums")
    @Expose
    private Albums albums;

    @SerializedName("related")
    @Expose
    private List<Related> related;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public TopLyrics getToplyrics() {
        return toplyrics;
    }

    public void setToplyrics(TopLyrics toplyrics) {
        this.toplyrics = toplyrics;
    }

    public Lyrics getLyrics() {
        return lyrics;
    }

    public void setLyrics(Lyrics lyrics) {
        this.lyrics = lyrics;
    }

    public Albums getAlbums() {
        return albums;
    }

    public void setAlbums(Albums albums) {
        this.albums = albums;
    }

    public List<Related> getRelated() {
        return related;
    }

    public void setRelated(List<Related> related) {
        this.related = related;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.desc);
        dest.writeString(this.url);
        dest.writeString(this.picSmall);
        dest.writeString(this.picMedium);
        dest.writeParcelable(this.rank, flags);
        dest.writeTypedList(this.genre);
        dest.writeParcelable(this.toplyrics, flags);
        dest.writeParcelable(this.lyrics, flags);
        dest.writeParcelable(this.albums, flags);
        dest.writeTypedList(this.related);
    }

    public Artist() {
    }

    protected Artist(Parcel in) {
        this.id = in.readString();
        this.desc = in.readString();
        this.url = in.readString();
        this.picSmall = in.readString();
        this.picMedium = in.readString();
        this.rank = in.readParcelable(Rank.class.getClassLoader());
        this.genre = in.createTypedArrayList(Genre.CREATOR);
        this.toplyrics = in.readParcelable(TopLyrics.class.getClassLoader());
        this.lyrics = in.readParcelable(Lyrics.class.getClassLoader());
        this.albums = in.readParcelable(Albums.class.getClassLoader());
        this.related = in.createTypedArrayList(Related.CREATOR);
    }

    public static final Creator<Artist> CREATOR = new Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel source) {
            return new Artist(source);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };
}
