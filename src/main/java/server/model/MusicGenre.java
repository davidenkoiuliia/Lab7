package server.model;



/**
 * The enum Music genre.
 */
public enum MusicGenre {
    /**
     * Psychedelic rock music genre.
     */
    PSYCHEDELIC_ROCK(3),
    /**
     * Rap music genre.
     */
    RAP(2),
    /**
     * Jazz music genre.
     */
    JAZZ(1);
    private int value;

    MusicGenre(int value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(int value) {
        this.value = value;
    }
}