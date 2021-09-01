package ocdev.com.br.lyricseditor.Model.RankingMusica.Artista;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Oto on 07/03/2018.
 */

public class ItemTopLyricsTraducao implements Parcelable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("turl")
    @Expose
    private String turl;

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

    public String getTurl() {
        return turl;
    }

    public void setTurl(String turl) {
        this.turl = turl;
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
        dest.writeString(this.turl);
    }

    public ItemTopLyricsTraducao() {
    }

    protected ItemTopLyricsTraducao(Parcel in) {
        this.id = in.readString();
        this.desc = in.readString();
        this.url = in.readString();
        this.turl = in.readString();
    }

    public static final Creator<ItemTopLyricsTraducao> CREATOR = new Creator<ItemTopLyricsTraducao>() {
        @Override
        public ItemTopLyricsTraducao createFromParcel(Parcel source) {
            return new ItemTopLyricsTraducao(source);
        }

        @Override
        public ItemTopLyricsTraducao[] newArray(int size) {
            return new ItemTopLyricsTraducao[size];
        }
    };
}
