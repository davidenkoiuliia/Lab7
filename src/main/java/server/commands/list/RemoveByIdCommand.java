package server.commands.list;

import server.commands.Command;
import server.controller.MusicController;
import server.exceptions.ArgumentException;

/**
 * The type Remove by key command.
 */
public class RemoveByIdCommand implements Command {
    private final MusicController controller;

    /**
     * Instantiates a new Remove by key command.
     *
     * @param controller the controller
     */
    public RemoveByIdCommand(MusicController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            throw new ArgumentException("Команда содержит 1 аргумент - id.");
        }
        try {
            long id = Long.parseLong(args[1]);
            if (controller.removeMusicBandById(id)) {
                System.out.println("Элемент удален успешно.");
            } else {
                System.out.println("Элемент не был удален.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Значение id целочисленно.");
        }
    }

    @Override
    public String description() {
        return "удаляет элемент по id.";
    }
}