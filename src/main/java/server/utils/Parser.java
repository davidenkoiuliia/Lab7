package server.utils;

import server.model.MusicGenre;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


/**
 * The type Parser.
 */
public class Parser {
    /**
     * Tilda resolver string.
     *
     * @param file the file
     * @return the string
     */
    public static String tildaResolver(String file) {
        if (file.startsWith("~")) {
            file = file.replaceFirst("^~", System.getProperty("user.home"));
        }
        return file;
    }

    /**
     * From local date time to date date.
     *
     * @param localDate the local date
     * @return the date
     */
    public static Date fromLocalDateTimeToDate(LocalDateTime localDate) {
        return Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * From string to music genre music genre.
     *
     * @param line the line
     * @return the music genre
     */
    public static MusicGenre fromStringToMusicGenre(String line) {
        switch (line.toUpperCase()) {
            case "1", "PSYCHEDELIC_ROCK" -> {
                return MusicGenre.PSYCHEDELIC_ROCK;
            }
            case "2", "RAP" -> {
                return MusicGenre.RAP;
            }
            case "3", "JAZZ" -> {
                return MusicGenre.JAZZ;
            }
            default -> {
                return MusicGenre.JAZZ;
            }
        }
    }
}
