/**
 * The AddIfMaxCommand class represents a command to add a new element to the collection if its value exceeds
 * the value of the maximum element in the collection.
 * It implements the BaseCommand interface.
 */
package commands;

import system.Receiver;


public class AddIfMaxCommand implements BaseCommand {

    /**
     * Executes the add_if_max command, adding a new element to the collection if its value exceeds
     * the value of the maximum element in the collection.
     * If the input contains more than one argument, it returns "Wrong argument".
     * Otherwise, it calls the addIfMax method of the Reciever class to add the element.
     *
     * @param inputLine the input command line
     * @return the result of the command execution
     */
    @Override
    public String execute(String inputLine) {
        if (inputLine.split(" ").length > 1){
            return "Wrong argument";
        }
        return Receiver.addIfMax();
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command ("add_if_max")
     */
    @Override
    public String getName() {
        return "add_if_max";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command ("добавить новый элемент в коллекцию, если его значение превышает " +
     *         "значение наибольшего элемента этой коллекции")
     */
    @Override
    public String getDescription() {
        return "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего " +
                "элемента этой коллекции";
    }
}
