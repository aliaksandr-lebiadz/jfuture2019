package dev.jfuture.task.parser.movie;

import dev.jfuture.task.entity.Movie;
import dev.jfuture.task.exception.WebsiteParsingException;

import java.util.List;

public interface MoviesParser {

    List<Movie> getMoviesByYear(int year) throws WebsiteParsingException;

}
