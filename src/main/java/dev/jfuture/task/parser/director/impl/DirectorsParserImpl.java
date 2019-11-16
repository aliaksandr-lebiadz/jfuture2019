package dev.jfuture.task.parser.director.impl;

import dev.jfuture.task.entity.Movie;
import dev.jfuture.task.exception.WebsiteParsingException;
import dev.jfuture.task.parser.director.DirectorsParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DirectorsParserImpl implements DirectorsParser {

    private static final String SOURCE = "https://www.imdb.com/chart/top";
    private static final String TABLE_CLASS = "chart";
    private static final String TITLE_CLASS = "titleColumn";
    private static final String RATING_CLASS = "ratingColumn";
    private static final String ROW_TAG = "tr";
    private static final String HYPERLINK_TAG = "a";

    private static final String DIRECTOR_ATTRIBUTE = "title";
    private static final String DIRECTOR = "(dir.)";

    private static final int HEADER_INDEX = 0;

    @Override
    public List<Movie> getTopMoviesByLimit(int amount) throws WebsiteParsingException {
        Elements rows = getTableRows();
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; movies.size() < amount; i++) {
            Element row = rows.get(i);
            Element titleAndDirectorElement = row.getElementsByClass(TITLE_CLASS)
                    .first()
                    .selectFirst(HYPERLINK_TAG);
            String title = titleAndDirectorElement.text();
            String director = getDirector(titleAndDirectorElement);
            String ratingValue = row.getElementsByClass(RATING_CLASS)
                    .first()
                    .text();
            double rating = Double.parseDouble(ratingValue);
            Movie movie = new Movie(title, director, rating);

            Optional<Movie> movieWithSameDirectorOptional = getMovieWithSuppliedDirector(movies, director);
            if (movieWithSameDirectorOptional.isPresent()) {
                Movie oldMovie = movieWithSameDirectorOptional.get();
                if (needsReplace(oldMovie, movie)) {
                    int index = movies.indexOf(oldMovie);
                    movies.set(index, movie);
                }
            } else {
                movies.add(movie);
            }
        }

        return movies;
    }

    private String getDirector(Element titleAndDirector) {
        String directorAndCast = titleAndDirector.attr(DIRECTOR_ATTRIBUTE);
        int directorLabelIndex = directorAndCast.indexOf(DIRECTOR);
        return directorAndCast.substring(0, directorLabelIndex).trim();
    }

    private Optional<Movie> getMovieWithSuppliedDirector(List<Movie> movies, String director) {
        for(Movie movie : movies){
            String movieDirector = movie.getDirector();
            if(movieDirector.equals(director)){
                return Optional.of(movie);
            }
        }
        return Optional.empty();
    }

    private boolean needsReplace(Movie oldMovie, Movie movie) {
        return movie.getRating() > oldMovie.getRating();
    }

    private Elements getTableRows() throws WebsiteParsingException{
        Document document;
        try {
            document = Jsoup.connect(SOURCE).get();
            Element body = document.body();
            Element table = body.getElementsByClass(TABLE_CLASS).first();
            Elements rows = table.select(ROW_TAG);
            removeHeader(rows);
            return rows;
        } catch (IOException ex) {
            throw new WebsiteParsingException(ex.getMessage(), ex);
        }
    }

    private void removeHeader(Elements rows){
        rows.remove(HEADER_INDEX);
    }
}
