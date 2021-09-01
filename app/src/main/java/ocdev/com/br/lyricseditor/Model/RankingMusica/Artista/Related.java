package ocdev.com.br.lyricseditor.Model.RankingMusica.Artista;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Oto on 08/03/2018.
 */

public class Related implements Parcelable{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.url);
    }

    public Related() {
    }

    protected Related(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.url = in.readString();
    }

    public static final Creator<Related> CREATOR = new Creator<Related>() {
        @Override
        public Related createFromParcel(Parcel source) {
            return new Related(source);
        }

        @Override
        public Related[] newArray(int size) {
            return new Related[size];
        }
    };
}