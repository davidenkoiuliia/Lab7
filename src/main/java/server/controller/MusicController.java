package server.controller;

import server.model.MusicBand;

import java.util.Hashtable;
import java.util.List;

/**
 * The interface Music controller.
 */
public interface MusicController {
    /**
     * Info string.
     *
     * @return the string
     */
    String info();

    /**
     * Gets music band by id.
     *
     * @param id the id
     * @return the music band by id
     */
    MusicBand getMusicBandById(long id);

    /**
     * Gets all music band.
     *
     * @return the all music band
     */
    List<MusicBand> getAllMusicBand();

    /**
     * Gets hash table of all music bands.
     *
     * @return the hash table of all music bands
     */
    Hashtable<Long, MusicBand> getHashTableOfAllMusicBands();

    /**
     * Insert music band by key long.
     *
     * @param key  the key
     * @param band the band
     * @return the long
     */
    long insertMusicBandByKey(long key, MusicBand band);

    /**
     * Update music band music band.
     *
     * @param band the band
     * @param id   the id
     * @return the music band
     */
    MusicBand updateMusicBand(MusicBand band, long id);

    /**
     * Remove music band by key boolean.
     *
     * @param key the key
     * @return the boolean
     */
    boolean removeMusicBandByKey(long key);

    /**
     * Clear.
     */
    void clear();

    /**
     * Save.
     */
    void save();

    /**
     * Replace if greater boolean.
     *
     * @param key  the key
     * @param band the band
     * @return the boolean
     */
    boolean replaceIfGreater(long key, MusicBand band);

    /**
     * Replace if lower boolean.
     *
     * @param key  the key
     * @param band the band
     * @return the boolean
     */
    boolean replaceIfLower(long key, MusicBand band);

    /**
     * Remove lower key boolean.
     *
     * @param key the key
     * @return the boolean
     */
    boolean removeLowerKey(long key);

    /**
     * Is key empty boolean.
     *
     * @param key the key
     * @return the boolean
     */
    boolean isKeyEmpty(long key);
}
