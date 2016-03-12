package aldo.cucea.test.com.ejemplos.models;

/**
 * Created by Titanium on 12/03/16.
 */
public class Car  {
    int imagen, rating;
    String name, description;

    public Car(int imagen, int rating, String name, String description) {
        this.imagen = imagen;
        this.rating = rating;
        this.name = name;
        this.description = description;
    }

    public int getImagen() {
        return imagen;
    }

    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
