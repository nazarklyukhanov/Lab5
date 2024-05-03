/**
 * The CommandManager class manages the execution of commands.
 */
package managers;

import commands.*;
import exceptions.NoCommandException;

import java.util.ArrayDeque;
import java.util.HashMap;

public class CommandManager {
    private static HashMap<String, BaseCommand> commandMap;
    public static ArrayDeque<BaseCommand> lastSixCommand = new ArrayDeque<>();

    /**
     * Constructs a new CommandManager and initializes the command map.
     */
    public CommandManager() {
        commandMap = new HashMap<>();
        commandMap.put("help", new HelpCommand());
        commandMap.put("add", new AddCommand());
        commandMap.put("info", new InfoCommand());
        commandMap.put("show", new ShowCommand());
        commandMap.put("save", new SaveCommand());
        commandMap.put("update_by_id", new UpdateByIDCommand());
        commandMap.put("remove_by_id", new RemoveByIDCommand());
        commandMap.put("clear", new ClearCommand());
        commandMap.put("add_if_max", new AddIfMaxCommand());
        commandMap.put("add_if_min", new AddIfMinCommand());
        commandMap.put("execute_script", new ExecuteScriptCommand());
        commandMap.put("exit", new ExitCommand());
        commandMap.put("history", new HistoryCommand());
        commandMap.put("remove_any_by_label", new RemoveAnyByLabelCommand());
        commandMap.put("filter_contains_name", new FilterContainsNameCommand());
        commandMap.put("print_field_ascending_label", new PrintFieldAscendingLabelCommand());
    }

    /**
     * Starts executing the specified command.
     *
     * @param input the input string containing the command
     * @return the result of executing the command
     * @throws NoCommandException if the command is not found
     */
    public static String startExecuting(String input) throws NoCommandException {
        String commandName = input.split(" ")[0];
        if (commandMap.containsKey(commandName)) {
            try {
                if (!(lastSixCommand == null) && lastSixCommand.size() == 13) {
                    lastSixCommand.pop();
                    lastSixCommand.addLast(commandMap.get(commandName));
                } else {
                    assert lastSixCommand != null;
                    lastSixCommand.addFirst(commandMap.get(commandName));
                }
                return commandMap.get(commandName).execute(input);
            } catch (Exception e) {
                return e.getMessage();
            }
        } else {
            throw new NoCommandException(input);
        }
    }

    /**
     * Returns the command map.
     *
     * @return the command map
     */
    public static HashMap<String, BaseCommand> getCommandMap() {
        return commandMap;
    }
}
