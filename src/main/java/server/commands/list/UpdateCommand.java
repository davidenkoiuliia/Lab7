package server.commands.list;

import server.builders.MusicBandBuilder;
import server.commands.Command;
import server.controller.MusicController;
import server.exceptions.ArgumentException;

/**
 * The type Update command.
 */
public class UpdateCommand implements Command {
    private final MusicController controller;

    /**
     * Instantiates a new Update command.
     *
     * @param controller the controller
     */
    public UpdateCommand(MusicController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            throw new ArgumentException("Команда содержит 1 аргумент - key.");
        }
        try {
            long key = Long.parseLong(args[1]);
            if (!controller.isKeyEmpty(key)) {
                controller.updateMusicBand(MusicBandBuilder.build(), key);
                System.out.println("MusicBand обновлен.");
            } else {
                System.out.println("MusicBand с таким key не найден.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Значение key целочисленно.");
        }
    }

    @Override
    public String description() {
        return "обновить существующий объект по id.";
    }
}
