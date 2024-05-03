/**
 * The BaseCommand interface represents the basic structure for all command classes.
 * It defines methods to execute a command, retrieve the name of the command, and get its description.
 */
package commands;

import exceptions.NoCommandException;
import exceptions.RootException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface BaseCommand {

    /**
     * Executes the command.
     *
     * @param inputLine the input command line
     * @return the result of the command execution
     * @throws RootException   if a general exception occurs during command execution
     * @throws IOException     if an I/O exception occurs during command execution
     * @throws NoCommandException if the specified command is not found or invalid
     */
    String execute(String inputLine) throws RootException, IOException, NoCommandException;

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    String getName();

    /**
     * Gets the description of the command.
     *
     * @return the description of the command
     */
    String getDescription();
}
