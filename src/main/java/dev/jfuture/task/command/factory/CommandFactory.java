package dev.jfuture.task.command.factory;

import dev.jfuture.task.command.Command;
import dev.jfuture.task.command.impl.ShowDynamicsCommand;
import dev.jfuture.task.command.impl.ShowTopDirectorsCommand;
import dev.jfuture.task.service.impl.MovieServiceImpl;

public class CommandFactory {

    private static final String SHOW_DYNAMICS_COMMAND = "showDynamicsCommand";
    private static final String SHOW_TOP_DIRECTORS_COMMAND = "showTopDirectorsCommand";

    public static Command create(String commandValue){
        switch (commandValue){
            case SHOW_DYNAMICS_COMMAND:
                return new ShowDynamicsCommand(new MovieServiceImpl());
            case SHOW_TOP_DIRECTORS_COMMAND:
                return new ShowTopDirectorsCommand(new MovieServiceImpl());
            default:
                throw new IllegalArgumentException("Invalid command value: " + commandValue);
        }
    }

}
