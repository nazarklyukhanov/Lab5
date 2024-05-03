/**
 * The InfoCommand class represents a command to display information about the collection.
 * It implements the BaseCommand interface.
 */
package commands;

import system.Receiver;

public class InfoCommand implements BaseCommand {

    /**
     * Executes the info command, displaying information about the collection.
     * If the input contains more than one argument, it returns "Wrong argument".
     * Otherwise, it calls the info method of the Reciever class to get information about the collection.
     *
     * @param inputLine the input command line
     * @return the information about the collection
     */
    @Override
    public String execute(String inputLine) {
        if (inputLine.split(" ").length > 1) {
            return "Wrong argument";
        }
        return Receiver.info();
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command ("info")
     */
    @Override
    public String getName() {
        return "info";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command ("вывести в стандартный поток вывода информацию о коллекции (тип, " +
     *         "дата инициализации, количество элементов и т.д.)")
     */
    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, " +
                "количество элементов и т.д.)";
    }
}
