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
    private static final String GENRES_SEPARATOR = ", ";

    @Override
    protected boolean isMovieTable(Element table) {
        String text = table.text();
        return text.contains(MOVIE_TABLE_QUALIFIER);
    }

    @Override
    protected Movie buildMovie(Elements cells, int year) {
        int titleColumn = cells.size() - 5;
        String title = getByIndex(cells, titleColumn);
        int genreColumn = cells.size() - 2;
        String genresStr = getByIndex(cells, genreColumn);
        List<String> genres = separateGenres(genresStr);
        return new Movie(title, COUNTRY, genres, year);
    }

    @Override
    protected Map<Integer, String> getSources() {
        Map<Integer, String> sources = new HashMap<>();
        sources.put(2017, SOURCE_2017);
        sources.put(2018, SOURCE_2018);
        sources.put(2019, SOURCE_2019);
        return sources;
    }

    @Override
    protected String getGenresSeparator() {
        return GENRES_SEPARATOR;
    }
}
