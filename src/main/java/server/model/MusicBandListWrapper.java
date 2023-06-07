package server.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Music band list wrapper.
 */
@XmlRootElement
public class MusicBandListWrapper {
    private List<MusicBand> band;

    /**
     * Gets band.
     *
     * @return the band
     */
    public List<MusicBand> getBand() {
        return band;
    }

    /**
     * Sets band.
     *
     * @param band the band
     */
    public void setBand(List<MusicBand> band) {
        this.band = band;
    }

    /**
     * Add band.
     *
     * @param band the band
     */
    public void addBand(MusicBand band) {
        if (this.band == null) {
            this.band = new ArrayList<>();
        }
        this.band.add(band);
    }
}
