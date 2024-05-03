/**
 * The ExecuteScriptCommand class represents a command to execute a script from a file.
 * It implements the BaseCommand interface.
 */
package commands;

import exceptions.NoCommandException;
import exceptions.RootException;
import exceptions.WrongArgumentException;
import managers.CollectionManager;
import managers.CommandManager;
import recources.Coordinates;
import recources.Label;
import recources.MusicBand;
import recources.MusicGenre;
import system.Validator;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Stack;

public class ExecuteScriptCommand implements BaseCommand {
    private static Stack<File> st = new Stack<>();

    /**
     * Executes the execute_script command, executing commands from a script file.
     * If the input does not contain exactly two arguments, it returns "Wrong argument".
     * Otherwise, it reads the specified file and executes the commands inside it.
     *
     * @param inputLine the input command line containing the path to the script file
     * @return an empty string
     * @throws RootException       if a general exception occurs during command execution
     * @throws IOException         if an I/O exception occurs during command execution
     * @throws NoCommandException if the specified command is not found or invalid
     */
    @Override
    public String execute(String inputLine) throws RootException, IOException, NoCommandException {
        if (inputLine.split(" ").length != 2) {
            return "Wrong argument";
        }
        String path = inputLine.split(" ")[1];
        File file = new File(path);
        if (!file.canRead()) {
            throw new RootException("Возникли проблемы с файлом");
        }
        if (st.isEmpty()) {
            st.add(file);
        }
        String line;
        st.add(file);
        var br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        String command;
        String[] data = new String[6];
        while ((line = br.readLine()) != null) {
            command = line.split(" ")[0];
            if (command.equals("add") || command.equals("update")) {
                String id = null;
                if (command.equals("update")) {
                    id = line.split(" ")[1];
                }
                for (int n = 0; n < 6; n++) {
                    if ((line = br.readLine()) != null) {
                        data[n] = line;
                    }
                }
                try {
                    Validator.isNotNull(data[0]);
                    Validator.XisCorrect(data[1].split(" ")[0]);
                    Validator.YisCorrect(data[1].split(" ")[1]);
                    Validator.isNotNullZero(data[2]);
                    Validator.isNotNullZero(data[3]);
                    Validator.isNotNullZero(data[5]);

                    MusicBand m1 = new MusicBand(data[0], new Coordinates(Float.parseFloat(data[1].split(" ")[0]),
                            Float.parseFloat(data[1].split(" ")[1])), Integer.parseInt(data[2]),
                            Integer.parseInt(data[3]),
                            MusicGenre.valueOf(data[4]), new Label(Integer.parseInt(data[5])));
                    if (command.equals("add")) {
                        CollectionManager.add(m1.getName(), m1);
                        System.out.println("Элемент был добавлен");
                    } else {
                        CollectionManager.removeById(Integer.parseInt(id));
                        m1.setId(Integer.parseInt(id));
                        CollectionManager.add(m1.getName(), m1);
                        System.out.println("Элемент был обновлен");
                    }
                } catch (WrongArgumentException e) {
                    System.out.println("Неизвестная ошибка");
                }
            } else {
                if (line.contains("execute_script")) {
                    File file_new = new File(line.split(" ")[1]);
                    if (!file_new.canRead()) {
                        throw new RootException("Возникли проблемы с файлом");
                    }
                    if (st.contains(file_new)) {
                        System.out.println("Рекурсия в файл " + file.getName() + " была пропущена");
                    } else {
                        System.out.println(CommandManager.startExecuting(line));
                    }
                } else {
                    System.out.println(CommandManager.startExecuting(line));
                }
            }
        }
        st.pop();
        return "";
    }

    /**
     * Gets the name of the command.
     *
     * @return null, as execute_script command doesn't have a fixed name
     */
    @Override
    public String getName() {
        return null;
    }

    /**
     * Gets the description of the command.
     *
     * @return null, as execute_script command doesn't have a fixed description
     */
    @Override
    public String getDescription() {
        return null;
    }
}
