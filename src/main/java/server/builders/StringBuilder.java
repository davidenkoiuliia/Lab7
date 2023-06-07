package server.builders;

import server.exceptions.ValidationException;

import java.util.Scanner;

import static server.validation.Validation.validateUserName;

/**
 * The type String builder.
 */
public class StringBuilder {
    /**
     * Build string.
     *
     * @param message the message
     * @return the string
     */
    public static String build(String message) {
        String name;
        try {
            System.out.println(message);
            Scanner sc = new Scanner(System.in);
            name = sc.nextLine();
            if (!validateUserName(name)) {
                throw new ValidationException("Неверный ввод. Поле не может быть быть пустым.");
            }
            return name;
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return build(message);
        }
    }
}
