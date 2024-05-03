/**
 * The UpdateByIDCommand class represents a command to update the value of an element in the collection by its ID.
 * It implements the BaseCommand interface.
 */
package commands;

import system.Receiver;

public class UpdateByIDCommand implements BaseCommand {

    /**
     * Executes the update_by_id command, updating the value of an element in the collection by its ID.
     * If the input does not contain exactly two arguments, it returns "Wrong argument".
     * Otherwise, it calls the update_by_id method of the Reciever class to update the element.
     *
     * @param inputLine the input command line containing the ID of the element to be updated
     * @return a message indicating the result of the update operation
     */
    @Override
    public String execute(String inputLine) {
        if (inputLine.split(" ").length != 2) {
            return "Wrong argument";
        }
        return Receiver.update_by_id(inputLine.split(" ")[1]);
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command ("update_by_id")
     */
    @Override
    public String getName() {
        return "update_by_id";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command ("обновить значение элемента коллекции, id которого равен заданному")
     */
    @Override
    public String getDescription() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }
}
