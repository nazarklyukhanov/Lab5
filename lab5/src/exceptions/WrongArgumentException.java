/**
 * The WrongArgumentException class represents an exception that is thrown when an invalid argument is provided.
 */
package exceptions;

public class WrongArgumentException extends Exception {

    /**
     * Constructs a new WrongArgumentException with the specified detail message.
     *
     * @param message the detail message
     */
    public WrongArgumentException(String message) {
        super(message);
    }
}
