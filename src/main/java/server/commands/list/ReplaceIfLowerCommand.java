package server.commands.list;

import server.builders.MusicBandBuilder;
import server.commands.Command;
import server.controller.MusicController;
import server.exceptions.ArgumentException;

/**
 * The type Replace if lower command.
 */
public class ReplaceIfLowerCommand implements Command {
    private final MusicController controller;

    /**
     * Instantiates a new Replace if lower command.
     *
     * @param controller the controller
     */
    public ReplaceIfLowerCommand(MusicController controller) {
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
                if (controller.replaceIfLower(key, MusicBandBuilder.build())) {
                    System.out.println("Элемент успешно заменен.");
                } else {
                    System.out.println("Элемент не был заменен. Не выполнено условие.");
                }
            } else {
                System.out.println("MusicBand с таким key не найден.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Значение key целочисленно.");
        }
    }

    @Override
    public String description() {
        return "заменить значение по ключу, если новое значение меньше старого";
    }
}
