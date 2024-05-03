/**
 * The Main class contains the entry point of the application.
 */
package system;

import exceptions.ReadFileException;
import exceptions.RootException;

public class Main {
    /**
     * The main method is the entry point of the application.
     *
     * @param args the command line arguments
     * @throws RootException if an error related to the root occurs
     * @throws ReadFileException if an error occurs while reading the file
     */
    public static void main(String[] args) throws RootException, ReadFileException {
        Console console = new Console(args[0]);
        console.start();
    }
}
