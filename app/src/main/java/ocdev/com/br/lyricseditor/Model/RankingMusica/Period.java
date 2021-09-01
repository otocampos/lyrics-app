package ocdev.com.br.lyricseditor.Model.RankingMusica;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oto on 01/03/2018.
 */

public class Period implements Parcelable {
    @SerializedName("year")
    private String year;
    @SerializedName("week")
    private String week;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.year);
        dest.writeString(this.week);
    }

    public Period() {
    }

    protected Period(Parcel in) {
        this.year = in.readString();
        this.week = in.readString();
    }

    public static final Creator<Period> CREATOR = new Creator<Period>() {
        @Override
        public Period createFromParcel(Parcel source) {
            return new Period(source);
        }

        @Override
        public Period[] newArray(int size) {
            return new Period[size];
        }
    };
}
