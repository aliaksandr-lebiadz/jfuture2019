package dev.jfuture.task.service;

import dev.jfuture.task.entity.Movie;
import dev.jfuture.task.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface MovieService {

    Map<String, Integer> getAmericanMoviesAmountOfGenresByYear(List<String> genres, int year) throws ServiceException;
    Map<String, Integer> getChineseMoviesAmountOfGenresByYear(List<String> genres, int year) throws ServiceException;
    List<String> getPopularGenres() throws ServiceException;

    List<Movie> getTopMoviesByLimit(int limit) throws ServiceException;

}
