package dev.jfuture.task.command.impl;

import dev.jfuture.task.command.Command;
import dev.jfuture.task.exception.ServiceException;
import dev.jfuture.task.service.MovieService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ShowDynamicsCommand implements Command {

    private static final String DYNAMICS_PAGE_URL = "/dynamics";
    private static final String AMERICAN_2017_ATTRIBUTE = "american_2017";
    private static final String AMERICAN_2018_ATTRIBUTE = "american_2018";
    private static final String AMERICAN_2019_ATTRIBUTE = "american_2019";
    private static final String CHINESE_2017_ATTRIBUTE = "chinese_2017";
    private static final String CHINESE_2018_ATTRIBUTE = "chinese_2018";
    private static final String CHINESE_2019_ATTRIBUTE = "chinese_2019";
    private static final String GENRES_ATTRIBUTE = "genres";

    private MovieService service;

    public ShowDynamicsCommand(MovieService service){
        this.service = service;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        List<String> popularGenres = service.getPopularGenres();
        request.setAttribute(GENRES_ATTRIBUTE, popularGenres);
        Map<String, Integer> american2017 = service.getAmericanMoviesAmountOfGenresByYear(popularGenres, 2017);
        Map<String, Integer> american2018 = service.getAmericanMoviesAmountOfGenresByYear(popularGenres, 2018);
        Map<String, Integer> american2019 = service.getAmericanMoviesAmountOfGenresByYear(popularGenres, 2019);
        request.setAttribute(AMERICAN_2017_ATTRIBUTE, american2017);
        request.setAttribute(AMERICAN_2018_ATTRIBUTE, american2018);
        request.setAttribute(AMERICAN_2019_ATTRIBUTE, american2019);
        Map<String, Integer> chinese2017 = service.getChineseMoviesAmountOfGenresByYear(popularGenres, 2017);
        Map<String, Integer> chinese2018 = service.getChineseMoviesAmountOfGenresByYear(popularGenres, 2018);
        Map<String, Integer> chinese2019 = service.getChineseMoviesAmountOfGenresByYear(popularGenres, 2019);
        request.setAttribute(CHINESE_2017_ATTRIBUTE, chinese2017);
        request.setAttribute(CHINESE_2018_ATTRIBUTE, chinese2018);
        request.setAttribute(CHINESE_2019_ATTRIBUTE, chinese2019);
        return DYNAMICS_PAGE_URL;
    }
}
