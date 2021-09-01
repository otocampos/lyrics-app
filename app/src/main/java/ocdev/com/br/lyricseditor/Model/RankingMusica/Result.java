package ocdev.com.br.lyricseditor.Model.RankingMusica;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oto on 01/03/2018.
 */

public class Result implements Parcelable {

    @SerializedName("mus")
    private Mus mus;

    @SerializedName("art")
    private Art art;

    public Mus getMus() {
        return mus;
    }

    public void setMus(Mus mus) {
        this.mus = mus;
    }

    public Art getArt() {
        return art;
    }

    public void setArt(Art art) {
        this.art = art;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mus, flags);
        dest.writeParcelable(this.art, flags);
    }

    public Result() {
    }

    protected Result(Parcel in) {
        this.mus = in.readParcelable(Mus.class.getClassLoader());
        this.art = in.readParcelable(Art.class.getClassLoader());
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel source) {
            return new Result(source);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };
}
