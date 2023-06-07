package server.commands.list;

import server.commands.Command;
import server.controller.MusicController;
import server.exceptions.ArgumentException;

/**
 * The type Clear command.
 */
public class ClearCommand implements Command {
    private final MusicController controller;

    /**
     * Instantiates a new Clear command.
     *
     * @param controller the controller
     */
    public ClearCommand(MusicController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            throw new ArgumentException("Команда не должна содержать аргументов.");
        }
        controller.clear();
        System.out.println("Успешно очищено");
    }

    @Override
    public String description() {
        return "очищает коллекцию.";
    }
}
