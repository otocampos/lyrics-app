package ocdev.com.br.lyricseditor.Model.RankingMusica;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oto on 01/03/2018.
 */

public class Mus implements Parcelable{

    @SerializedName("week")
private Week week;

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.week, flags);
    }

    public Mus() {
    }

    protected Mus(Parcel in) {
        this.week = in.readParcelable(Week.class.getClassLoader());
    }

    public static final Creator<Mus> CREATOR = new Creator<Mus>() {
        @Override
        public Mus createFromParcel(Parcel source) {
            return new Mus(source);
        }

        @Override
        public Mus[] newArray(int size) {
            return new Mus[size];
        }
    };
}
