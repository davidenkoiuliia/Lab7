package server.commands.list;

import server.commands.Command;
import server.exceptions.ArgumentException;

/**
 * The type Exit command.
 */
public class ExitCommand implements Command {

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            throw new ArgumentException("Команда не должна содержать аргументов.");
        }
    }

    @Override
    public String description() {
        return "завершить программу.";
    }
}
