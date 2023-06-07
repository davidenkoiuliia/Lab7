package server.builders;

import server.model.Album;

import java.util.Scanner;

/**
 * The type Album builder.
 */
public class AlbumBuilder {
    /**
     * Build album.
     *
     * @return the album
     */
    public static Album build() {
        Album album = new Album();
        album.setName(StringBuilder.build("Введите название альбома:"));
        album.setLength(intBuild());
        return album;
    }

    private static int intBuild() {
        try {
            System.out.println("Введитен длину альбома: ");
            Scanner sc = new Scanner(System.in);
            int value = Integer.parseInt(sc.nextLine());
            if (value <= 0) {
                System.out.println("Значение должно быть больше нуля.");
                return intBuild();
            }
            return value;
        } catch (NumberFormatException e) {
            System.out.println("Это поле принимает числовое значение.");
            return intBuild();
        }
    }
}
