package ocdev.com.br.lyricseditor.Model.RankingMusica.Artista;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Oto on 07/03/2018.
 */

public class TopLyrics implements Parcelable {
    @SerializedName("item")
    @Expose
    private List<ItemTopLyrics> item = null;

    public List<ItemTopLyrics> getItem() {
        return item;
    }

    public void setItem(List<ItemTopLyrics> item) {
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

    public TopLyrics() {
    }

    protected TopLyrics(Parcel in) {
        this.item = in.createTypedArrayList(ItemTopLyrics.CREATOR);
    }

    public static final Creator<TopLyrics> CREATOR = new Creator<TopLyrics>() {
        @Override
        public TopLyrics createFromParcel(Parcel source) {
            return new TopLyrics(source);
        }

        @Override
        public TopLyrics[] newArray(int size) {
            return new TopLyrics[size];
        }
    };
}
