package ocdev.com.br.lyricseditor.Model.RankingMusica.Artista;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Oto on 07/03/2018.
 */

public class Albums implements Parcelable{

    @SerializedName("item")
    @Expose
    private List<ItemAlbums> item = null;

    public List<ItemAlbums> getItem() {
        return item;
    }

    public void setItem(List<ItemAlbums> item) {
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

    public Albums() {
    }

    protected Albums(Parcel in) {
        this.item = in.createTypedArrayList(ItemAlbums.CREATOR);
    }

    public static final Creator<Albums> CREATOR = new Creator<Albums>() {
        @Override
        public Albums createFromParcel(Parcel source) {
            return new Albums(source);
        }

        @Override
        public Albums[] newArray(int size) {
            return new Albums[size];
        }
    };
}
