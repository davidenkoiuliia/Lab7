package server.commands.list;

import server.builders.MusicBandBuilder;
import server.commands.Command;
import server.controller.MusicController;
import server.exceptions.ArgumentException;


/**
 * The type Insert command.
 */
public class InsertCommand implements Command {
    private final MusicController controller;

    /**
     * Instantiates a new Insert command.
     *
     * @param controller the controller
     */
    public InsertCommand(MusicController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            throw new ArgumentException("Команда содержит 1 аргумент - key.");
        }
        try {
            long key = Long.parseLong(args[1]);
            if (controller.isKeyEmpty(key)) {
                controller.insertMusicBandByKey(key, MusicBandBuilder.build());
                System.out.println("Элемент добавлен.");
            } else {
                System.out.println("Данный ключ занят.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Значение key целочисленно.");
        }
    }

    @Override
    public String description() {
        return "добавляет элемент в коллекцию.";
    }
}
