package aldo.cucea.test.com.ejemplos.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Titanium on 09/04/16.
 */
public class Movie implements Parcelable {
    private String title, description, poster, thumbnail;
    private double popularity, rating;

    public Movie(String title, String description, String poster, String thumbnail, double popularity, double rating) {
        this.title = title;
        this.description = description;
        this.poster = poster;
        this.thumbnail = thumbnail;
        this.popularity = popularity;
        this.rating = rating;
    }

    protected Movie(Parcel in) {
        title = in.readString();
        description = in.readString();
        poster = in.readString();
        thumbnail = in.readString();
        popularity = in.readDouble();
        rating = in.readDouble();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(poster);
        dest.writeString(thumbnail);
        dest.writeDouble(popularity);
        dest.writeDouble(rating);
    }

    public String toString(){
        String res = "";
        res = res + title + "\n\n";
        res = res + description;
        return res;
    }
}

//Repositorio de popular movies
//https://github.com/giovas17/


