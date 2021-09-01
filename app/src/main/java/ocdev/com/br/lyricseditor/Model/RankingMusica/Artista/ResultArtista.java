package ocdev.com.br.lyricseditor.Model.RankingMusica.Artista;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Oto on 07/03/2018.
 */

public class ResultArtista implements Parcelable{

    @SerializedName("artist")
    @Expose
    private Artist artist;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.artist, flags);
    }

    public ResultArtista() {
    }

    protected ResultArtista(Parcel in) {
        this.artist = in.readParcelable(Artist.class.getClassLoader());
    }

    public static final Creator<ResultArtista> CREATOR = new Creator<ResultArtista>() {
        @Override
        public ResultArtista createFromParcel(Parcel source) {
            return new ResultArtista(source);
        }

        @Override
        public ResultArtista[] newArray(int size) {
            return new ResultArtista[size];
        }
    };
}