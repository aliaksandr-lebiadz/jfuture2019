package dev.jfuture.task.command.factory;

import dev.jfuture.task.command.Command;

public interface CommandFactory {

    Command create(String commandValue);

}
