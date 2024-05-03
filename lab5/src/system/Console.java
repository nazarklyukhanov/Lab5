/**
 * The Console class represents the console interface for interacting with the application.
 */
package system;

import exceptions.ReadFileException;
import exceptions.RootException;
import filelogic.ReaderXML;
import filelogic.WriterXML;
import managers.CommandManager;

import java.util.Scanner;

public class Console {
    private static String file_path; // The path of the file
    /**
     * Constructs a Console object with the specified file path.
     *
     * @param path the path of the file
     */
    public Console(String path){
        this.file_path = path;
    }

    /**
     * Starts the console interface and handles user input.
     *
     * @throws RootException if an error related to the root occurs
     * @throws ReadFileException if an error occurs while reading the file
     */
    protected void start() throws RootException, ReadFileException {
        CommandManager cm = new CommandManager();
        ReaderXML.read(Console.getFile_path());
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){
            String input = sc.nextLine();
            try {
                System.out.println(cm.startExecuting(input));
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Gets the file path.
     *
     * @return the file path
     */
    public static String getFile_path() {
        return file_path;
    }
}
