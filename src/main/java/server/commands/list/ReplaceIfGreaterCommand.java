package server.commands.list;

import server.builders.MusicBandBuilder;
import server.commands.Command;
import server.controller.MusicController;
import server.exceptions.ArgumentException;

/**
 * The type Replace if greater command.
 */
public class ReplaceIfGreaterCommand implements Command {
    private final MusicController controller;

    /**
     * Instantiates a new Replace if greater command.
     *
     * @param controller the controller
     */
    public ReplaceIfGreaterCommand(MusicController controller) {
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
                if (controller.replaceIfGreater(key, MusicBandBuilder.build())) {
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
        return "заменить значение по ключу, если новое значение больше старого";
    }
}
