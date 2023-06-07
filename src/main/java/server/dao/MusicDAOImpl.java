package server.dao;

import server.database.DataBaseProvider;
import server.model.MusicBand;

import java.util.Hashtable;
import java.util.List;

/**
 * Класс для взаимодействия с базой данных.
 */
public class MusicDAOImpl implements MusicDAO {
    private final DataBaseProvider source;

    /**
     * Instantiates a new Music dao.
     *
     * @param fileName the file name
     */
    public MusicDAOImpl(String fileName) {
        this.source = new DataBaseProvider(fileName);
    }

    @Override
    public String info() {
        String answer = ("Данные о базе данных: \n");
        answer += "Тип: " + source.getDataBase().getClass().getTypeName().split("\\.")[2] + "\n";
        answer += "Время создания: " + source.getDateTime().toString() + "\n";
        answer += "Элементов внутри: " + (source.getDataBase().size()) + "\n";
        return answer;
    }

    @Override
    public MusicBand getMusicBandById(long id) {
        return source.getDataBase().get(id);
    }

    @Override
    public List<MusicBand> getAllMusicBand() {
        return source.getList();
    }

    @Override
    public Hashtable<Long, MusicBand> getHashTableOfAllMusicBands() {
        return new Hashtable<>(source.getDataBase());
    }

    @Override
    public long insertMusicBandByKey(long key, MusicBand band) {
        return source.addMusicBandToDatabase(key, band);
    }

    @Override
    public MusicBand updateMusicBand(MusicBand band, long key) {
        return source.getDataBase().get(key).update(band);
    }

    @Override
    public boolean removeMusicBandByKey(long id) {
        int before = source.getList().size();
        source.getDataBase().remove(id);
        int after = source.getList().size();
        int diff = before - after;
        source.reorderId();
        return diff > 0;
    }

    @Override
    public void clear() {
        source.getDataBase().clear();
    }

    @Override
    public void save() {
        source.save();
    }

    @Override
    public boolean replaceIfGreater(long key, MusicBand band) {
        if (source.getDataBase().containsKey(key)) {
            MusicBand inBase = source.getDataBase().get(key);
            if (inBase.compareTo(band) > 0) {
                inBase.update(band);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean replaceIfLower(long key, MusicBand band) {
        if (source.getDataBase().containsKey(key)) {
            MusicBand inBase = source.getDataBase().get(key);
            if (inBase.compareTo(band) < 0) {
                inBase.update(band);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeLowerKey(long key) {
        int before = source.getList().size();
        source.getDataBase().keySet().removeIf(k -> k < key);
        int after = source.getList().size();
        int diff = before - after;
        source.reorderId();
        return diff > 0;
    }

    @Override
    public boolean isKeyEmpty(long key) {
        return !source.getDataBase().containsKey(key);
    }
}
