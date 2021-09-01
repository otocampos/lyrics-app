package ocdev.com.br.lyricseditor.Model.RankingMusica.Artista;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Oto on 07/03/2018.
 */

public class ItemTopLyrics implements Parcelable{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("url")
    @Expose
    private String url;

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.desc);
        dest.writeString(this.url);
    }

    public ItemTopLyrics() {
    }

    protected ItemTopLyrics(Parcel in) {
        this.id = in.readString();
        this.desc = in.readString();
        this.url = in.readString();
    }

    public static final Creator<ItemTopLyrics> CREATOR = new Creator<ItemTopLyrics>() {
        @Override
        public ItemTopLyrics createFromParcel(Parcel source) {
            return new ItemTopLyrics(source);
        }

        @Override
        public ItemTopLyrics[] newArray(int size) {
            return new ItemTopLyrics[size];
        }
    };
}

