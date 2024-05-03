/**
 * The ReadFileException class represents an exception that is thrown when an error occurs while reading a file.
 */
package exceptions;

public class ReadFileException extends Exception {

    /**
     * Constructs a new ReadFileException with the specified detail message.
     */
    public ReadFileException() {
        super("Read file exception");
    }
}
