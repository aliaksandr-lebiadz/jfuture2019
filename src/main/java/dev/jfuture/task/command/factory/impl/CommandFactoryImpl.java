package dev.jfuture.task.command.factory.impl;

import dev.jfuture.task.command.Command;
import dev.jfuture.task.command.factory.CommandFactory;
import dev.jfuture.task.command.impl.ShowDynamicsCommand;
import dev.jfuture.task.command.impl.ShowTopDirectorsCommand;
import dev.jfuture.task.service.impl.MovieServiceImpl;

public class CommandFactoryImpl implements CommandFactory {

    private static final String SHOW_DYNAMICS_COMMAND = "showDynamicsCommand";
    private static final String SHOW_TOP_DIRECTORS_COMMAND = "showTopDirectorsCommand";

    @Override
    public Command create(String commandValue){
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
