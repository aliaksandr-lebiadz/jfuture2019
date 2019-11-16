package dev.jfuture.task.service.impl;

import dev.jfuture.task.calculator.MoviesCalculator;
import dev.jfuture.task.calculator.MoviesCalculatorHelper;
import dev.jfuture.task.entity.Movie;
import dev.jfuture.task.exception.ServiceException;
import dev.jfuture.task.exception.WebsiteParsingException;
import dev.jfuture.task.parser.director.DirectorsParser;
import dev.jfuture.task.parser.director.impl.DirectorsParserImpl;
import dev.jfuture.task.parser.movie.MoviesParser;
import dev.jfuture.task.parser.movie.impl.AmericanMoviesParser;
import dev.jfuture.task.parser.movie.impl.ChineseMoviesParser;
import dev.jfuture.task.service.MovieService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MovieServiceImpl implements MovieService {

    private static final int YEAR_2017 = 2017;
    private static final int YEAR_2018 = 2018;
    private static final int YEAR_2019 = 2019;
    private static final int GENRES_LIMIT = 5;

    private MoviesCalculator calculator = new MoviesCalculator();
    private MoviesParser americanMoviesParser = new AmericanMoviesParser();
    private MoviesParser chineseMoviesParser = new ChineseMoviesParser();

    @Override
    public Map<String, Integer> getAmericanMoviesAmountOfGenresByYear(List<String> genres, int year)
            throws ServiceException{
        try{
            List<Movie> americanMoviesOfCertainYear = americanMoviesParser.getMoviesByYear(year);
            return calculator.calculateMoviesAmountOfCertainGenres(americanMoviesOfCertainYear, genres);
        } catch (WebsiteParsingException ex){
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    @Override
    public Map<String, Integer> getChineseMoviesAmountOfGenresByYear(List<String> genres, int year)
            throws ServiceException {
        try{
            List<Movie> chineseMoviesOfCertainYear = chineseMoviesParser.getMoviesByYear(year);
            return calculator.calculateMoviesAmountOfCertainGenres(chineseMoviesOfCertainYear, genres);
        } catch (WebsiteParsingException ex){
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    @Override
    public List<String> getPopularGenres() throws ServiceException{
        try{
            List<Movie> americanMoviesOf2017 = americanMoviesParser.getMoviesByYear(YEAR_2017);
            List<Movie> americanMoviesOf2018 = americanMoviesParser.getMoviesByYear(YEAR_2018);
            List<Movie> americanMoviesOf2019 = americanMoviesParser.getMoviesByYear(YEAR_2019);
            List<Movie> chineseMoviesOf2017 = chineseMoviesParser.getMoviesByYear(YEAR_2017);
            List<Movie> chineseMoviesOf2018 = chineseMoviesParser.getMoviesByYear(YEAR_2018);
            List<Movie> chineseMoviesOf2019 = chineseMoviesParser.getMoviesByYear(YEAR_2019);
            List<Movie> allMovies = new ArrayList<>();
            allMovies.addAll(americanMoviesOf2017);
            allMovies.addAll(americanMoviesOf2018);
            allMovies.addAll(americanMoviesOf2019);
            allMovies.addAll(chineseMoviesOf2017);
            allMovies.addAll(chineseMoviesOf2018);
            allMovies.addAll(chineseMoviesOf2019);
            MoviesCalculatorHelper moviesCalculatorHelper = new MoviesCalculatorHelper();
            return moviesCalculatorHelper.getPopularGenresByLimit(allMovies, GENRES_LIMIT);
        } catch (WebsiteParsingException ex){
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    @Override
    public List<Movie> getTopMoviesByLimit(int limit) throws ServiceException {
        try{
            DirectorsParser parser = new DirectorsParserImpl();
            return parser.getTopMoviesByLimit(limit);
        } catch (WebsiteParsingException ex){
            throw new ServiceException(ex.getMessage(), ex);
        }
    }
}
