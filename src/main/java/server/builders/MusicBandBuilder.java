package server.builders;

import server.model.MusicBand;

import java.util.Scanner;

/**
 * The type Music band builder.
 */
public class MusicBandBuilder {
    /**
     * Build music band.
     *
     * @return the music band
     */
    public static MusicBand build() {
        MusicBand response = new MusicBand();
        response.setName(StringBuilder.build("Введите название группы:"));
        response.setCoordinates(CoordinatesBuilder.build());
        response.setNumberOfParticipants(longBuild());
        response.setGenre(MusicGenreBuilder.build());
        response.setBestAlbum(AlbumBuilder.build());
        return response;
    }

    private static Long longBuild() {
        try {
            System.out.println("Введитен число numberOfParticipants: ");
            Scanner sc = new Scanner(System.in);
            long value = Long.parseLong(sc.nextLine());
            if (value <= 0) {
                System.out.println("Значение должно быть больше нуля.");
                return longBuild();
            }
            return value;
        } catch (NumberFormatException e) {
            System.out.println("Это поле принимает числовое значение.");
            return longBuild();
        }
    }
}
