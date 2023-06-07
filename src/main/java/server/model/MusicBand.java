package server.model;


import server.services.LocalDateTimeAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The type Music band.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicBand implements Comparable<MusicBand> {
    private long id;
    private String name;
    private Coordinates coordinates;
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime creationDate;
    private long numberOfParticipants;
    private MusicGenre genre;
    private Album bestAlbum;
    private long keyInDataMap;

    /**
     * Instantiates a new Music band.
     *
     * @param id                   the id
     * @param name                 the name
     * @param coordinates          the coordinates
     * @param creationDate         the creation date
     * @param numberOfParticipants the number of participants
     * @param genre                the genre
     * @param bestAlbum            the best album
     */
    public MusicBand(long id, String name, Coordinates coordinates, LocalDateTime creationDate, long numberOfParticipants, MusicGenre genre, Album bestAlbum) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.numberOfParticipants = numberOfParticipants;
        this.genre = genre;
        this.bestAlbum = bestAlbum;
    }

    /**
     * Instantiates a new Music band.
     *
     * @param name                 the name
     * @param coordinates          the coordinates
     * @param creationDate         the creation date
     * @param numberOfParticipants the number of participants
     * @param genre                the genre
     * @param bestAlbum            the best album
     */
    public MusicBand(String name, Coordinates coordinates, LocalDateTime creationDate, long numberOfParticipants, MusicGenre genre, Album bestAlbum) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.numberOfParticipants = numberOfParticipants;
        this.genre = genre;
        this.bestAlbum = bestAlbum;
    }

    /**
     * Instantiates a new Music band.
     */
    public MusicBand() {
        creationDate = LocalDateTime.now();
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets coordinates.
     *
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Sets coordinates.
     *
     * @param coordinates the coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Sets creation date.
     *
     * @param creationDate the creation date
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets number of participants.
     *
     * @return the number of participants
     */
    public long getNumberOfParticipants() {
        return numberOfParticipants;
    }

    /**
     * Sets number of participants.
     *
     * @param numberOfParticipants the number of participants
     */
    public void setNumberOfParticipants(long numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    /**
     * Gets genre.
     *
     * @return the genre
     */
    public MusicGenre getGenre() {
        return genre;
    }

    /**
     * Sets genre.
     *
     * @param genre the genre
     */
    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    /**
     * Gets best album.
     *
     * @return the best album
     */
    public Album getBestAlbum() {
        return bestAlbum;
    }

    /**
     * Sets best album.
     *
     * @param bestAlbum the best album
     */
    public void setBestAlbum(Album bestAlbum) {
        this.bestAlbum = bestAlbum;
    }

    /**
     * Gets key in data map.
     *
     * @return the key in data map
     */
    public long getKeyInDataMap() {
        return keyInDataMap;
    }

    /**
     * Sets key in data map.
     *
     * @param keyInDataMap the key in data map
     */
    public void setKeyInDataMap(long keyInDataMap) {
        this.keyInDataMap = keyInDataMap;
    }

    /**
     * Update music band.
     *
     * @param band the band
     * @return the music band
     */
    public MusicBand update(MusicBand band) {
        setName(band.getName());
        setCoordinates(band.getCoordinates());
        setNumberOfParticipants(band.getNumberOfParticipants());
        setGenre(band.getGenre());
        setBestAlbum(band.getBestAlbum());
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MusicBand band = (MusicBand) o;

        if (id != band.id) return false;
        if (numberOfParticipants != band.numberOfParticipants) return false;
        if (!Objects.equals(name, band.name)) return false;
        if (!Objects.equals(coordinates, band.coordinates)) return false;
        if (!Objects.equals(creationDate, band.creationDate)) return false;
        if (genre != band.genre) return false;
        return Objects.equals(bestAlbum, band.bestAlbum);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (int) (numberOfParticipants ^ (numberOfParticipants >>> 32));
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (bestAlbum != null ? bestAlbum.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MusicBand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", numberOfParticipants=" + numberOfParticipants +
                ", genre=" + genre +
                ", bestAlbum=" + bestAlbum +
                '}';
    }

    @Override
    public int compareTo(MusicBand o) {
        return (int) (numberOfParticipants - o.numberOfParticipants);
    }
}