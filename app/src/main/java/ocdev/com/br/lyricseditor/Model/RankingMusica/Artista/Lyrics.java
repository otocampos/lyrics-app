package ocdev.com.br.lyricseditor.Model.RankingMusica.Artista;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Oto on 07/03/2018.
 */

public class Lyrics implements Parcelable {

    @SerializedName("item")
    @Expose
    private List<ItemTopLyricsTraducao> item = null;

    public List<ItemTopLyricsTraducao> getItem() {
        return item;
    }

    public void setItem(List<ItemTopLyricsTraducao> item) {
        this.item = item;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.item);
    }

    public Lyrics() {
    }

    protected Lyrics(Parcel in) {
        this.item = in.createTypedArrayList(ItemTopLyricsTraducao.CREATOR);
    }

    public static final Creator<Lyrics> CREATOR = new Creator<Lyrics>() {
        @Override
        public Lyrics createFromParcel(Parcel source) {
            return new Lyrics(source);
        }

        @Override
        public Lyrics[] newArray(int size) {
            return new Lyrics[size];
        }
    };
}
