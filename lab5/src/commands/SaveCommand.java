/**
 * The SaveCommand class represents a command to save the collection to a file.
 * It implements the BaseCommand interface.
 */
package commands;

import system.Receiver;

public class SaveCommand implements BaseCommand {

    /**
     * Executes the save command, saving the collection to a file.
     * If the input contains more than one argument, it returns "Wrong argument".
     * Otherwise, it calls the save method of the Reciever class to save the collection.
     * If an exception occurs during the saving process, it catches the exception and returns "Error".
     *
     * @param inputLine the input command line
     * @return a message indicating the result of the saving operation
     */
    @Override
    public String execute(String inputLine) {
        if (inputLine.split(" ").length > 1) {
            return "Wrong argument";
        }
        try {
            return Receiver.save();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error";
        }
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command ("save")
     */
    @Override
    public String getName() {
        return "save";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command ("сохранить коллекцию в файл")
     */
    @Override
    public String getDescription() {
        return "сохранить коллекцию в файл";
    }
}
