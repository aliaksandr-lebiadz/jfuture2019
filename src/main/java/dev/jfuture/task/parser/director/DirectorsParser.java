package dev.jfuture.task.parser.director;

import dev.jfuture.task.entity.Movie;
import dev.jfuture.task.exception.WebsiteParsingException;

import java.util.List;

public interface DirectorsParser {

    List<Movie> getTopMoviesByLimit(int amount) throws WebsiteParsingException;

}
