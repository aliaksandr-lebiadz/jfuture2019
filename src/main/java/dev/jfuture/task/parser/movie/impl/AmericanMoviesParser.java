package dev.jfuture.task.parser.movie.impl;

import dev.jfuture.task.entity.Movie;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmericanMoviesParser extends AbstractMoviesParser {

    private static final String MOVIE_TABLE_QUALIFIER = "Cast and crew";
    private static final String COUNTRY = "USA";
    private static final String SOURCE_2017 = "https://en.wikipedia.org/w/index.php?title=List_of_American_films_of_2017&oldid=925576219";
    private static final String SOURCE_2018 = "https://en.wikipedia.org/w/index.php?title=List_of_American_films_of_2018&oldid=925576149";
    private static final String SOURCE_2019 = "https://en.wikipedia.org/w/index.php?title=List_of_American_films_of_2019&oldid=925616104";
    private static final int YEAR_2017 = 2017;
    private static final int YEAR_2018 = 2018;
    private static final int YEAR_2019 = 2019;
    private static final int TITLE_COLUMN_INDEX = 1;
    private static final int GENRES_COLUMN_INDEX = 4;
    private static final String GENRES_SEPARATOR = ", ";

    @Override
    protected String getMovieTableQualifier() {
        return MOVIE_TABLE_QUALIFIER;
    }

    @Override
    protected Movie buildMovie(Elements columns, int year) {
        String title = getByIndex(columns, TITLE_COLUMN_INDEX);
        String genresStr = getByIndex(columns, GENRES_COLUMN_INDEX);
        List<String> genres = separateGenres(genresStr);
        return new Movie(title, COUNTRY, genres, year);
    }

    @Override
    protected Map<Integer, String> getSources() {
        Map<Integer, String> sources = new HashMap<>();
        sources.put(YEAR_2017, SOURCE_2017);
        sources.put(YEAR_2018, SOURCE_2018);
        sources.put(YEAR_2019, SOURCE_2019);
        return sources;
    }

    @Override
    protected String getGenresSeparator() {
        return GENRES_SEPARATOR;
    }
}
