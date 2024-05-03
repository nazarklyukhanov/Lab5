/**
 * The FilterContainsNameCommand class represents a command to filter elements by name containing a specified substring.
 * It implements the BaseCommand interface.
 */
package commands;

import exceptions.NoCommandException;
import exceptions.RootException;
import system.Receiver;

import java.io.IOException;

public class FilterContainsNameCommand implements BaseCommand {

    /**
     * Executes the filter_contains_name command, filtering elements by name containing a specified substring.
     * If the input does not contain exactly two arguments, it returns "Wrong argument".
     * Otherwise, it calls the filterContainsName method of the Reciever class to perform the filtering.
     *
     * @param inputLine the input command line containing the substring to filter by
     * @return the result of the filtering operation
     * @throws RootException       if a general exception occurs during command execution
     * @throws IOException         if an I/O exception occurs during command execution
     * @throws NoCommandException if the specified command is not found or invalid
     */
    @Override
    public String execute(String inputLine) throws RootException, IOException, NoCommandException {
        if (inputLine.split(" ").length != 2) {
            return "Wrong argument";
        }
        return Receiver.filterContainsName(inputLine.split(" ")[1]);
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command ("filter_contains_name")
     */
    @Override
    public String getName() {
        return "filter_contains_name";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command ("вывести элементы, значение поля name которых содержит заданную подстроку")
     */
    @Override
    public String getDescription() {
        return "вывести элементы, значение поля name которых содержит заданную подстроку";
    }
}
