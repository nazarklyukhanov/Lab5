/**
 * The ClearCommand class represents a command to clear the collection.
 * It implements the BaseCommand interface.
 */
package commands;

import managers.CollectionManager;

public class ClearCommand implements BaseCommand {

    /**
     * Executes the clear command, clearing the collection.
     * If the input contains more than one argument, it returns "Wrong argument".
     * Otherwise, it clears the collection using the CollectionManager.
     *
     * @param inputLine the input command line
     * @return a message indicating that the collection has been cleared
     */
    @Override
    public String execute(String inputLine) {
        if (inputLine.split(" ").length > 1){
            return "Wrong argument";
        }
        CollectionManager.getLinkedHashMap().clear();
        return "Ваша коллекция очищена";
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command ("clear")
     */
    @Override
    public String getName() {
        return "clear";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command ("очистить коллекцию")
     */
    @Override
    public String getDescription() {
        return "очистить коллекцию";
    }
}
