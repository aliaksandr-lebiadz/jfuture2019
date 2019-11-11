package dev.jfuture.task.command.impl;

import dev.jfuture.task.command.Command;
import dev.jfuture.task.entity.Movie;
import dev.jfuture.task.exception.ServiceException;
import dev.jfuture.task.service.MovieService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowTopDirectorsCommand implements Command {

    private static final String DIRECTORS_PAGE_URL = "/directors";
    private static final String MOVIES_ATTRIBUTE = "movies";

    private MovieService service;

    public ShowTopDirectorsCommand(MovieService service){
        this.service = service;
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        List<Movie> movies = service.getTopMoviesByLimit(5);
        request.setAttribute(MOVIES_ATTRIBUTE, movies);
        return DIRECTORS_PAGE_URL;
    }
}
