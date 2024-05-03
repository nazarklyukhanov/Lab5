/**
 * The BaseReader interface represents a contract for classes that read data from a file.
 */
package filelogic;

import java.io.IOException;

public interface BaseReader {

    /**
     * Reads data from the specified file path.
     *
     * @param path the path of the file to read from
     * @throws IOException if an I/O error occurs while reading from the file
     */
    void readFromPath(String path) throws IOException;
}
