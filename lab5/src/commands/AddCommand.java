/**
 * The AddCommand class represents a command to add a new element to the collection.
 * It implements the BaseCommand interface.
 */
package commands;

import managers.CollectionManager;
import managers.CommandManager;
import recources.MusicBand;
import system.Receiver;

import java.util.Scanner;

public class AddCommand implements BaseCommand {

    /**
     * Executes the add command, adding a new element to the collection.
     * If the input contains more than one argument, it returns "Wrong argument".
     * Otherwise, it calls the add method of the Reciever class to add the element.
     *
     * @param inputLine the input command line
     * @return the result of the command execution
     */
    @Override
    public String execute(String inputLine) {
        if (inputLine.split(" ").length > 1){
            return "Wrong argument";
        }
        return Receiver.add();
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command ("add")
     */
    @Override
    public String getName() {
        return "add";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command ("добавить новый элемент в коллекцию")
     */
    @Override
    public String getDescription() {
        return "добавить новый элемент в коллекцию";
    }
}
