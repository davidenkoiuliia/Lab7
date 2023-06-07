package client;

import server.commands.Invoker;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

/**
 * Класс, считывающий пользовательский ввод с клавиатуры и вызывающий метод execute у Invoker на введеную строку.
 */
public class ConsoleUI {
    private final Invoker invoker;

    /**
     * Instantiates a new Console ui.
     *
     * @param invoker the invoker
     */
    public ConsoleUI(Invoker invoker) {
        this.invoker = invoker;
    }

    /**
     * Метод отвечающий за ввод со строки. Чтение идет до тех пор, пока не будет встречена команда exit/null (ctrl + D)
     * Buffered reader создается в invoker и оттуда берется для чтения со строки.
     *
     * IOException -- ошибка BufferedReader
     */
    public void start() {
        String command;
        BufferedReader reader = invoker.getReader();

        try (reader) {
            System.out.println("Напишите help чтобы увидеть все команды.");
            while (!Objects.equals(command = reader.readLine(), "exit") && !Objects.equals(command, null)) {
                invoker.execute(command);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
