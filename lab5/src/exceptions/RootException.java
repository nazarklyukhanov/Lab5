/**
 * The RootException class represents a generic exception that serves as the root for all custom exceptions in the system.
 */
package exceptions;

public class RootException extends Exception {

    /**
     * Constructs a new RootException with the specified detail message.
     *
     * @param message the detail message
     */
    public RootException(String message) {
        super(message);
    }
}
