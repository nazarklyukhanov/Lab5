/**
 * The HelpCommand class represents a command to display help information about available commands.
 * It implements the BaseCommand interface.
 */
package commands;

import system.Receiver;

public class HelpCommand implements BaseCommand {

    /**
     * Executes the help command, displaying help information about available commands.
     * If the input contains more than one argument, it returns "Wrong argument".
     * Otherwise, it calls the help method of the Reciever class to display the help information.
     *
     * @param inputLine the input command line
     * @return the help information about available commands
     */
    @Override
    public String execute(String inputLine) {
        if (inputLine.split(" ").length > 1) {
            return "Wrong argument";
        }
        return Receiver.help();
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command ("help")
     */
    @Override
    public String getName() {
        return "help";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command ("вывести справку по доступным командам")
     */
    @Override
    public String getDescription() {
        return "вывести справку по доступным командам";
    }
}
