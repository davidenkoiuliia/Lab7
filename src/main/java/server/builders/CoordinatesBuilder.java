package server.builders;

import server.exceptions.ValidationException;
import server.model.Coordinates;

import java.util.Scanner;

/**
 * The type Coordinates builder.
 */
public class CoordinatesBuilder {
    /**
     * Build coordinates.
     *
     * @return the coordinates
     */
    public static Coordinates build() {
        long x;
        int y;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите координату x");
            x = Long.parseLong(sc.nextLine());
            System.out.println("Введите координату y");
            y = Integer.parseInt(sc.nextLine());
            if (x < -475) {
                throw new ValidationException("Значение x должно быть больше -475");
            }
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return build();
        } catch (NumberFormatException e) {
            System.out.println(("Координаты принимают числовые значения"));
            return build();
        }
        return new Coordinates(x, y);
    }
}
