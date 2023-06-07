package server.commands.list;

import server.commands.Command;
import server.commands.Invoker;
import server.exceptions.ArgumentException;

import java.util.Map;

import static client.ConsoleColors.*;

/**
 * The type Help command.
 */
public class HelpCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            throw new ArgumentException("Команда не должна содержать аргументов.");
        }
        for (Map.Entry<String, Command> pair : Invoker.getCommandMap().entrySet()) {
            System.out.println(PURPLE + pair.getKey() + RESET + WHITE + " : " + pair.getValue().description() + RESET);
        }
    }

    @Override
    public String description() {
        return "вывести все команды.";
    }
}
