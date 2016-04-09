package aldo.cucea.test.com.ejemplos.models;

/**
 * Created by Titanium on 09/04/16.
 */
public class Movie {
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
}
