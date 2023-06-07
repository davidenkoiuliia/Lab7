package server.validation;

import server.exceptions.FileException;
import server.model.Coordinates;
import server.model.MusicBand;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

import static server.utils.Parser.tildaResolver;

/**
 * The type Validation.
 */
public class Validation {
    /**
     * Validate music band boolean.
     *
     * @param musicBand the music band
     * @param idList    the id list
     * @param keyList   the key list
     * @return the boolean
     */
    public static boolean validateMusicBand(MusicBand musicBand, ArrayList<Long> idList, ArrayList<Long> keyList) {
        if (musicBand.getId() <= 0 || idList.contains(musicBand.getId()))
            return false;
        if (keyList.contains(musicBand.getKeyInDataMap()))
            return false;
        if (musicBand.getName() == null || musicBand.getName().trim().equals("")) return false;
        if (musicBand.getCoordinates() == null || musicBand.getCoordinates().getX() <= -475) return false;
        if (musicBand.getCreationDate() == null) return false;
        if (musicBand.getNumberOfParticipants() <= 0) return false;
        if (musicBand.getBestAlbum().getName() == null || musicBand.getBestAlbum().getName().trim().equals("")) return false;
        if (musicBand.getBestAlbum().getLength() <= 0) return  false;
        return musicBand.getGenre() != null;
    }

    /**
     * Validate file exist.
     *
     * @param file the file
     */
    public static void validateFileExist(File file) {
        if (!Files.exists(file.toPath())) {
            throw new FileException("Файл не существует.");
        }
    }

    /**
     * Validate file read.
     *
     * @param file the file
     */
    public static void validateFileRead(File file) {
        if (!Files.isReadable(file.toPath())) {
            throw new FileException("Файл недоступен для чтения.");
        }
    }

    /**
     * Validate file write.
     *
     * @param file the file
     */
    public static void validateFileWrite(File file) {
        if (!Files.isWritable(file.toPath())) {
            throw new FileException("Файл недоступен для записи.");
        }
    }

    /**
     * Validate file name.
     *
     * @param fileName the file name
     */
    public static void validateFileName(String fileName) {
        try {
            (new File(fileName.replace("~", ""))).toPath();
        } catch (InvalidPathException e) {
            throw new FileException("Некорректное имя файла.");
        }
    }

    /**
     * Validate file directory.
     *
     * @param fileName the file name
     */
    public static void validateFileDirectory(String fileName) {
        if (Files.isDirectory(Paths.get(fileName))) {
            throw new FileException("Файл является директорией.");
        }
    }

    /**
     * Validate file.
     *
     * @param fileName the file name
     */
    public static void validateFile(String fileName) {
        fileName = tildaResolver(fileName);
        validateFileName(fileName);
        File file = new File(fileName);
        validateFileDirectory(fileName);
        validateFileExist(file);
        validateFileRead(file);
        validateFileWrite(file);
    }


    /**
     * Validate coordinate boolean.
     *
     * @param coordinates the coordinates
     * @return the boolean
     */
    public static boolean validateCoordinate(Coordinates coordinates) {
        return !(coordinates != null && coordinates.getY() <= 655);
    }

    /**
     * Validate user name boolean.
     *
     * @param userName the user name
     * @return the boolean
     */
    public static boolean validateUserName(String userName) {
        return (userName != null && !userName.trim().equals("") && userName.length() > 0);
    }

    /**
     * Validate id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean validateId(Long id) {
        return (id != null && id > 0);
    }
}
