package server.commands.list;

import server.commands.Command;
import server.controller.MusicController;
import server.exceptions.ArgumentException;

/**
 * The type Remove by key command.
 */
public class RemoveByKeyCommand implements Command {
    private final MusicController controller;

    /**
     * Instantiates a new Remove by key command.
     *
     * @param controller the controller
     */
    public RemoveByKeyCommand(MusicController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            throw new ArgumentException("Команда содержит 1 аргумент - key.");
        }
        try {
            long key = Long.parseLong(args[1]);
            if (controller.removeMusicBandByKey(key)) {
                System.out.println("Элемент удален успешно.");
            } else {
                System.out.println("Элемент не был удален.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Значение key целочисленно.");
        }
    }

    @Override
    public String description() {
        return "удаляет элемент по ключу.";
    }
}
