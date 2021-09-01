package ocdev.com.br.lyricseditor.Model.RankingMusica.Artista;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Oto on 07/03/2018.
 */

public class ItemAlbums implements Parcelable{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("label")
    @Expose
    private String label;

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
        dest.writeString(this.year);
        dest.writeString(this.label);
    }

    public ItemAlbums() {
    }

    protected ItemAlbums(Parcel in) {
        this.id = in.readString();
        this.desc = in.readString();
        this.url = in.readString();
        this.year = in.readString();
        this.label = in.readString();
    }

    public static final Creator<ItemAlbums> CREATOR = new Creator<ItemAlbums>() {
        @Override
        public ItemAlbums createFromParcel(Parcel source) {
            return new ItemAlbums(source);
        }

        @Override
        public ItemAlbums[] newArray(int size) {
            return new ItemAlbums[size];
        }
    };
}
