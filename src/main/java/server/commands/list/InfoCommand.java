package server.commands.list;

import server.commands.Command;
import server.controller.MusicController;
import server.exceptions.ArgumentException;

/**
 * The type Info command.
 */
public class InfoCommand implements Command {
    private final MusicController controller;

    /**
     * Instantiates a new Info command.
     *
     * @param controller the controller
     */
    public InfoCommand(MusicController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            throw new ArgumentException("Команда не должна содержать аргументов.");
        }
        System.out.println(controller.info());
    }

    @Override
    public String description() {
        return "выводит информацию о базе данных.";
    }
}
