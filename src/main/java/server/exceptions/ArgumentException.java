package server.exceptions;

/**
 * The type Argument exception.
 */
public class ArgumentException extends RuntimeException {
    /**
     * Instantiates a new Argument exception.
     *
     * @param message the message
     */
    public ArgumentException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Argument exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
