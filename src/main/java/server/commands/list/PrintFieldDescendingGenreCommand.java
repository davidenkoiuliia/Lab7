package server.commands.list;

import server.commands.Command;
import server.controller.MusicController;
import server.exceptions.ArgumentException;
import server.model.MusicBand;
import server.model.MusicGenre;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The type Print field descending genre command.
 */
public class PrintFieldDescendingGenreCommand implements Command {
    private final MusicController controller;

    /**
     * Instantiates a new Print field descending genre command.
     *
     * @param controller the controller
     */
    public PrintFieldDescendingGenreCommand(MusicController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            throw new ArgumentException("Команда не должна содержать аргументов.");
        }
        List<MusicGenre> list = new ArrayList<>(controller.getAllMusicBand().stream().map(MusicBand::getGenre).toList());
        list.sort(Comparator.comparingInt(MusicGenre::getValue));
        System.out.println(list);
    }

    @Override
    public String description() {
        return " вывести значения поля genre всех элементов в порядке убывания";
    }
}
