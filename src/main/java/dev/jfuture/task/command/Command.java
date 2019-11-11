package dev.jfuture.task.command;

import dev.jfuture.task.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException;

}
