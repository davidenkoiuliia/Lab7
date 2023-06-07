package server.controller;

import server.dao.MusicDAO;
import server.dao.MusicDAOImpl;
import server.model.MusicBand;

import java.util.Hashtable;
import java.util.List;

/**
 * Класс для валидации данных, введенных пользовалем
 */
public class MusicControllerImpl implements MusicController {
    private MusicDAO musicDAO;

    /**
     * Instantiates a new Music controller.
     *
     * @param fileName the file name
     */
    public MusicControllerImpl(String fileName) {
        this.musicDAO = new MusicDAOImpl(fileName);
    }

    @Override
    public String info() {
        return musicDAO.info();
    }

    @Override
    public MusicBand getMusicBandById(long id) {
        return musicDAO.getMusicBandById(id);
    }

    @Override
    public List<MusicBand> getAllMusicBand() {
        return musicDAO.getAllMusicBand();
    }

    @Override
    public Hashtable<Long, MusicBand> getHashTableOfAllMusicBands() {
        return musicDAO.getHashTableOfAllMusicBands();
    }

    @Override
    public long insertMusicBandByKey(long key, MusicBand band) {
        return musicDAO.insertMusicBandByKey(key, band);
    }

    @Override
    public MusicBand updateMusicBand(MusicBand band, long id) {
        return musicDAO.updateMusicBand(band, id);
    }

    @Override
    public boolean removeMusicBandByKey(long key) {
        return musicDAO.removeMusicBandByKey(key);
    }

    @Override
    public void clear() {
        musicDAO.clear();
    }

    @Override
    public void save() {
        musicDAO.save();
    }

    @Override
    public boolean replaceIfGreater(long key, MusicBand band) {
        return musicDAO.replaceIfGreater(key, band);
    }

    @Override
    public boolean replaceIfLower(long key, MusicBand band) {
        return musicDAO.replaceIfLower(key, band);
    }

    @Override
    public boolean removeLowerKey(long key) {
        return musicDAO.removeLowerKey(key);
    }

    @Override
    public boolean isKeyEmpty(long key) {
        return musicDAO.isKeyEmpty(key);
    }

    /**
     * Gets music band dao.
     *
     * @return the music band dao
     */
    public MusicDAO getMusicBandDAO() {
        return musicDAO;
    }

    /**
     * Sets music band dao.
     *
     * @param musicDAO the music dao
     */
    public void setMusicBandDAO(MusicDAO musicDAO) {
        this.musicDAO = musicDAO;
    }

}
