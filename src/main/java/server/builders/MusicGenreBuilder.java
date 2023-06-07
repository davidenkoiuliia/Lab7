package server.builders;

import server.model.MusicGenre;

import java.util.Scanner;

import static server.utils.Parser.fromStringToMusicGenre;

/**
 * The type Music genre builder.
 */
public class MusicGenreBuilder {
    /**
     * Build music genre.
     *
     * @return the music genre
     */
    public static MusicGenre build() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите жанр музыки: (1 - PSYCHEDELIC_ROCK, 2 - RAP, 3 - JAZZ, DEFAULT - JAZZ)");
        return fromStringToMusicGenre(sc.nextLine());
    }
}
