/**
 * The ShowCommand class represents a command to display all elements of the collection in a string representation.
 * It implements the BaseCommand interface.
 */
package commands;

import system.Receiver;

public class ShowCommand implements BaseCommand {

    /**
     * Executes the show command, displaying all elements of the collection in a string representation.
     * If the input contains more than one argument, it returns "Wrong argument".
     * Otherwise, it calls the show method of the Reciever class to display the collection.
     *
     * @param inputLine the input command line
     * @return a string representation of all elements in the collection
     */
    @Override
    public String execute(String inputLine) {
        if (inputLine.split(" ").length > 1) {
            return "Wrong argument";
        }
        return Receiver.show();
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command ("show")
     */
    @Override
    public String getName() {
        return "show";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command ("вывести в стандартный поток вывода все элементы коллекции в строковом представлении")
     */
    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
