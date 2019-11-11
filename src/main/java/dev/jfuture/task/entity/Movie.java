package dev.jfuture.task.entity;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private String title;
    private String country;
    private List<String> genres;
    private String director;
    private double rating;
    private int year;

    public Movie(String title, String country, List<String> genres, int year){
        this.title = title;
        this.country = country;
        this.genres = new ArrayList<>(genres);
        this.year = year;
    }

    public Movie(String title, String director, double rating){
        this.title = title;
        this.director = director;
        this.rating = rating;
    }

    public List<String> getGenres() {
        return new ArrayList<>(genres);
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder(getClass().getName() + "@" +
                "title: " + title +
                ", country: " + country +
                ", year: " + year +
                ", genres: ");
        for(String genre : genres) {
            builder.append(genre);
            if(genres.indexOf(genre) != genres.size() - 1){
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    public String getDirector() {
        return director;
    }

    public double getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }
}
