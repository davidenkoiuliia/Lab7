package server.commands.list;

import server.commands.Command;
import server.controller.MusicController;
import server.exceptions.ArgumentException;

/**
 * The type Show command.
 */
public class ShowCommand implements Command {
    private final MusicController controller;

    /**
     * Instantiates a new Show command.
     *
     * @param controller the controller
     */
    public ShowCommand(MusicController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            throw new ArgumentException("Команда не должна содержать аргументов.");
        }
        controller.getHashTableOfAllMusicBands().forEach((aLong, band) -> System.out.println(aLong.toString() + " : " + band.toString()));
        System.out.println("Выведено " + controller.getAllMusicBand().size() + " объектов.");
    }

    @Override
    public String description() {
        return "выводит все объекты.";
    }
}
