package server.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The type Coordinates.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Coordinates {
    private long x; //Значение поля должно быть больше -475, Поле не может быть null
    private int y; //Поле не может быть null

    /**
     * Instantiates a new Coordinates.
     *
     * @param x the x
     * @param y the y
     */
    public Coordinates(long x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Instantiates a new Coordinates.
     */
    public Coordinates() {
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public long getX() {
        return x;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(long x) {
        this.x = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public long getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}