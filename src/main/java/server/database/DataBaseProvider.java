package server.database;


import server.model.MusicBand;
import server.model.MusicBandListWrapper;
import server.validation.Validation;

import javax.xml.bind.JAXBException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import static server.services.XMLFileManager.*;
import static server.validation.Validation.validateFile;

/**
 * Класс имитирующий поведение базы данных.
 */
public class DataBaseProvider {
    private final Hashtable<Long, MusicBand> dataBase;
    private final LocalDateTime dateTime;
    private final String fileName;

    /**
     * Валидируется файл. Загружает базу данных. Время создание устанавливается с созданим класса.
     *
     * @param filename the filename
     */
    public DataBaseProvider(String filename) {
        validateFile(filename);
        this.fileName = filename;
        this.dataBase = loadDataBase(filename);
        this.dateTime = LocalDateTime.now();
    }
    private synchronized Long generateNextId() {
        long maxId = 0;
        for (MusicBand musicBand : dataBase.values()) {
            maxId = Math.max(maxId, musicBand.getId());
        }
        return maxId + 1;
    }

    /**
     * Метод для валидации списка MusicBand из XML файла.
     * @param bands
     * @return
     */
    private static List<MusicBand> validateList(List<MusicBand> bands){
        ArrayList<Long> idList = new ArrayList<>(bands.stream().map(MusicBand::getId).toList());
        ArrayList<Long> keyList = new ArrayList<>(bands.stream().map(MusicBand::getKeyInDataMap).toList());
        bands.removeIf(band -> Validation.validateMusicBand(band, idList, keyList));
        return bands;
    }
    /**
     * Загрузка базы данных из файла.
     * @param fileName
     * @return
     */
    private static Hashtable<Long, MusicBand> loadDataBase(String fileName) {
        try {
            List<MusicBand> fromXml = deserializeMusicBandListFromXml(fileName);

            Hashtable<Long, MusicBand> result = new Hashtable<>();
            for (MusicBand musicBand : validateList(fromXml)) {
                result.put(musicBand.getKeyInDataMap(), musicBand);
            }
            return result;
        } catch (JAXBException e){
            System.out.println("Ошибка сериализации в xml. Сохранение не удалось.");
            return new Hashtable<>();
        }
    }

    /**
     * Save.
     */
    public void save() {
        validateFile(fileName);
        MusicBandListWrapper list = new MusicBandListWrapper();
        list.setBand(getList());
        try {
            saveToFile(serializeMusicBandListToXml(list), fileName);
        } catch (JAXBException e){
            System.out.println("Ошибка сериализации в xml. Сохранение не удалось.");
        }
    }

    /**
     * Add music band to database long.
     *
     * @param key   the key
     * @param model the model
     * @return the long
     */
    public Long addMusicBandToDatabase(long key, MusicBand model) {
        if (!dataBase.containsKey(key)) {
            model.setId(generateNextId());
            model.setKeyInDataMap(key);
            dataBase.put(key, model);
            reorderId();
            return key;
        }
        return -1L;
    }

    /**
     * Remove music band from data base boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean removeMusicBandFromDataBase(Long id) {
        dataBase.remove(id);
        reorderId();
        return true;
    }

    /**
     * Reorder id.
     * Ставит порядок id musicBand от 1 до n, без пропусков.
     */
    public void reorderId(){
        for (int i = 0; i < dataBase.values().size(); i++){
            if (dataBase.values().stream().toList().get(i).getId() != i+1){
                dataBase.values().stream().toList().get(i).setId(i+1);
            }
        }
    }

    /**
     * Gets data base.
     *
     * @return the data base
     */
    public Hashtable<Long, MusicBand> getDataBase() {
        return dataBase;
    }

    /**
     * Gets list.
     *
     * @return the list
     */
    public List<MusicBand> getList() {
        return new ArrayList<>(dataBase.values());
    }

    /**
     * Gets date time.
     *
     * @return the date time
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
