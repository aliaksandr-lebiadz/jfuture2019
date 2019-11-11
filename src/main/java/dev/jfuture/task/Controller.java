package dev.jfuture.task;

import dev.jfuture.task.command.Command;
import dev.jfuture.task.command.factory.CommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller")
public class Controller extends HttpServlet {

    private static final String COMMAND_PARAMETER = "command";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        try{
            String commandValue = request.getParameter(COMMAND_PARAMETER);
            Command command = CommandFactory.create(commandValue);
            String page = command.execute(request, response);
            RequestDispatcher dispatcher = request.getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } catch (Exception ex){
            throw new ServletException(ex.getMessage(), ex);
        }
    }

}
