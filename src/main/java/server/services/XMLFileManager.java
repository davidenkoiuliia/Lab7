package server.services;

import server.model.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

/**
 * The type Xml file manager.
 */
public class XMLFileManager {
    private final String filename;

    /**
     * Instantiates a new Xml file manager.
     *
     * @param filename the filename
     */
    public XMLFileManager(String filename) {
        this.filename = filename;
    }

    /**
     * Serialize music band to xml string.
     *
     * @param musicBand the music band
     * @return the string
     * @throws JAXBException the jaxb exception
     */
    public static String serializeMusicBandToXml(MusicBand musicBand) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(MusicBand.class);

        Marshaller marshaller = jaxbContext.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter writer = new StringWriter();
        marshaller.marshal(musicBand, writer);

        return writer.toString();
    }

    /**
     * Serialize music band list to xml string.
     *
     * @param list the list
     * @return the string
     * @throws JAXBException the jaxb exception
     */
    public static String serializeMusicBandListToXml(MusicBandListWrapper list) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(MusicBandListWrapper.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter writer = new StringWriter();
        marshaller.marshal(list, writer);

        return writer.toString();
    }

    /**
     * Deserialize music band list from xml list.
     *
     * @param xmlFilePath the xml file path
     * @return the list
     * @throws JAXBException the jaxb exception
     */
    public static List<MusicBand> deserializeMusicBandListFromXml(String xmlFilePath) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(MusicBandListWrapper.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        File file = new File(xmlFilePath);
        MusicBandListWrapper musicBandListWrapper = (MusicBandListWrapper) unmarshaller.unmarshal(file);

        return musicBandListWrapper.getBand();
    }

    /**
     * Save to file.
     *
     * @param xmlString the xml string
     * @param filename  the filename
     */
    public static void saveToFile(String xmlString, String filename){
        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write(xmlString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets filename.
     *
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }
}
