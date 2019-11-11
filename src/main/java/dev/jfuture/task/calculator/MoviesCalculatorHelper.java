package dev.jfuture.task.calculator;

import dev.jfuture.task.entity.Movie;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MoviesCalculatorHelper {

    public List<String> getPopularGenresByLimit(List<Movie> movies, int limit){
        Map<String, Integer> genresOccurrence = new HashMap<>();
        for(Movie movie : movies){
            List<String> genres = movie.getGenres();
            for(String genre : genres){
                if(genresOccurrence.containsKey(genre)){
                    int currentOccurrence = genresOccurrence.get(genre);
                    int newOccurrence = currentOccurrence + 1;
                    genresOccurrence.put(genre, newOccurrence);
                } else{
                    genresOccurrence.put(genre, 1);
                }
            }
        }
        return genresOccurrence
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

}
