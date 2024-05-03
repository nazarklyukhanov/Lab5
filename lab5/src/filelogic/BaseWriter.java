/**
 * The BaseWriter interface represents a contract for classes that write data to a file in XML format.
 */
package filelogic;

import java.io.IOException;

public interface BaseWriter {

    /**
     * Writes data to the specified file path in XML format.
     *
     * @param path the path of the file to write to
     * @throws IOException if an I/O error occurs while writing to the file
     */
    void writeToPathXML(String path) throws IOException;
}
