package dev.jfuture.task.parser.movie.impl;

import dev.jfuture.task.entity.Movie;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChineseMoviesParser extends AbstractMoviesParser{

    private static final String MOVIE_TABLE_QUALIFIER = "Cast";
    private static final String COUNTRY = "China";
    private static final String SOURCE_2017 = "https://en.wikipedia.org/w/index.php?title=List_of_Chinese_films_of_2017&oldid=923009452";
    private static final String SOURCE_2018 = "https://en.wikipedia.org/w/index.php?title=List_of_Chinese_films_of_2018&oldid=900037799";
    private static final String SOURCE_2019 = "https://en.wikipedia.org/w/index.php?title=List_of_Chinese_films_of_2019&oldid=925625488";
    private static final String GENRES_SEPARATOR = " / ";

    @Override
    protected boolean isMovieTable(Element table) {
        String text = table.text();
        return text.contains(MOVIE_TABLE_QUALIFIER);
    }

    @Override
    protected Movie buildMovie(Elements cells, int year) {
        int titleColumn = cells.size() - 6;
        String title = getByIndex(cells, titleColumn);
        int genreColumn = cells.size() - 3;
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
