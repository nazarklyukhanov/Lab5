/**
 * The RemoveAnyByLabelCommand class represents a command to remove one element from the collection
 * based on the specified label value.
 * It implements the BaseCommand interface.
 */
package commands;

import exceptions.NoCommandException;
import exceptions.RootException;
import system.Receiver;


import java.io.IOException;

public class RemoveAnyByLabelCommand implements BaseCommand {

    /**
     * Executes the remove_any_by_label command, removing one element from the collection
     * based on the specified label value.
     * If the input does not contain exactly two arguments, it returns "Wrong argument".
     * Otherwise, it calls the removeAnyByLabel method of the Reciever class to remove the element.
     *
     * @param inputLine the input command line containing the label value
     * @return a message indicating the result of the removal operation
     * @throws RootException       if a general exception occurs during command execution
     * @throws IOException         if an I/O exception occurs during command execution
     * @throws NoCommandException if the specified command is not found or invalid
     */
    @Override
    public String execute(String inputLine) throws RootException, IOException, NoCommandException {
        if (inputLine.split(" ").length != 2) {
            return "Wrong argument";
        }
        return Receiver.removeAnyByLabel(inputLine.split(" ")[1]);
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command ("remove_any_by_label")
     */
    @Override
    public String getName() {
        return "remove_any_by_label";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command ("удалить из коллекции один элемент, значение поля label которого эквивалентно заданному")
     */
    @Override
    public String getDescription() {
        return "удалить из коллекции один элемент, значение поля label которого эквивалентно заданному";
    }
}
