/**
 * The NoCommandException class represents an exception that is thrown when a command is not found or invalid.
 */
package exceptions;

public class NoCommandException extends Exception {

    /**
     * Constructs a new NoCommandException with the specified detail message.
     *
     * @param name the name of the command that caused the exception
     */
    public NoCommandException(String name) {
        super("No command " + name);
    }
}
