package server.commands;

/**
 * Интерфейс для того, чтобы показывать, что класс реализует команду.
 */
public interface Command {
    /**
     * Исполняет команду. В аргументы передается [commandName, ...] и аргументы.
     *
     * @param args the args
     */
    void execute(String[] args);

    /**
     * Содержит строку описания команды. Вызывается в help команде.
     *
     * @return the string
     */
    String description();
}
