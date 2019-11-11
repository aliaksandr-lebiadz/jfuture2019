package dev.jfuture.task.calculator;

import dev.jfuture.task.entity.Movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoviesCalculator {

    public Map<String, Integer> calculateMoviesAmountOfCertainGenres(List<Movie> movies, List<String> genres){
        Map<String, Integer> moviesAmountByGenres = new HashMap<>();
        for(String genre : genres){
            int amount = calculateMoviesAmountOfCertainGenre(movies, genre);
            moviesAmountByGenres.put(genre, amount);
        }
        return moviesAmountByGenres;
    }

    private int calculateMoviesAmountOfCertainGenre(List<Movie> movies, String genre){
        int amount = 0;
        for(Movie movie : movies){
            List<String> movieGenres = movie.getGenres();
            if(movieGenres.contains(genre)){
                amount++;
            }
        }
        return amount;
    }

}
