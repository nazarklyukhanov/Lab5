/**
 * The RemoveByIDCommand class represents a command to remove an element from the collection by its ID.
 * It implements the BaseCommand interface.
 */
package commands;

import system.Receiver;

public class RemoveByIDCommand implements BaseCommand {

    /**
     * Executes the remove_by_id command, removing an element from the collection by its ID.
     * If the input does not contain exactly two arguments, it returns "Wrong argument".
     * Otherwise, it calls the remove_by_id method of the Reciever class to remove the element.
     *
     * @param inputLine the input command line containing the ID of the element to be removed
     * @return a message indicating the result of the removal operation
     */
    @Override
    public String execute(String inputLine) {
        if (inputLine.split(" ").length != 2) {
            return "Wrong argument";
        }
        return Receiver.remove_by_id(inputLine.split(" ")[1]);
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command ("remove_by_id")
     */
    @Override
    public String getName() {
        return "remove_by_id";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command ("удалить элемент из коллекции по его id")
     */
    @Override
    public String getDescription() {
        return "удалить элемент из коллекции по его id";
    }
}
