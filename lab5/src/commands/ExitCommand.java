/**
 * The ExitCommand class represents a command to exit the program without saving to a file.
 * It implements the BaseCommand interface.
 */
package commands;

import exceptions.NoCommandException;
import exceptions.RootException;

import java.io.IOException;

public class ExitCommand implements BaseCommand{
    /**
     * Executes the exit command, terminating the program without saving to a file.
     * If the input contains more than one argument, it returns "Wrong argument".
     * Otherwise, it terminates the program using System.exit(1).
     *
     * @param inputLine the input command line
     * @return a message indicating successful exit
     * @throws RootException       if a general exception occurs during command execution
     * @throws IOException         if an I/O exception occurs during command execution
     * @throws NoCommandException if the specified command is not found or invalid
     */
    @Override
    public String execute(String inputLine) throws RootException, IOException, NoCommandException {
        if (inputLine.split(" ").length > 1){
            return "Wrong argument";
        }
        System.exit(1);
        return "Успешно вышли";
    }
    /**
     * Gets the name of the command.
     *
     * @return the name of the command ("exit")
     */
    @Override
    public String getName() {
        return "exit";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command ("завершить программу (без сохранения в файл)")
     */
    @Override
    public String getDescription() {
        return "завершить программу (без сохранения в файл)";
    }
}
