/**
 * The AddIfMinCommand class represents a command to add a new element to the collection if its value is less
 * than the value of the minimum element in the collection.
 * It implements the BaseCommand interface.
 */
package commands;

import system.Receiver;

public class AddIfMinCommand implements BaseCommand {

    /**
     * Executes the add_if_min command, adding a new element to the collection if its value is less
     * than the value of the minimum element in the collection.
     * If the input contains more than one argument, it returns "Wrong argument".
     * Otherwise, it calls the addIfMin method of the Reciever class to add the element.
     *
     * @param inputLine the input command line
     * @return the result of the command execution
     */
    @Override
    public String execute(String inputLine) {
        if (inputLine.split(" ").length > 1){
            return "Wrong argument";
        }
        return Receiver.addIfMin();
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command ("add_if_min")
     */
    @Override
    public String getName() {
        return "add_if_min";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command ("добавить новый элемент в коллекцию, если его значение меньше, " +
     *         "чем у наименьшего элемента этой коллекции")
     */
    @Override
    public String getDescription() {
        return "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }
}
