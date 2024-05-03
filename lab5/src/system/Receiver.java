package system;

import commands.BaseCommand;
import exceptions.RootException;
import exceptions.WrongArgumentException;
import filelogic.WriterXML;
import managers.CollectionManager;
import managers.CommandManager;
import recources.Coordinates;
import recources.Label;
import recources.MusicBand;
import recources.MusicGenre;
import recources.comparators.MusicBandComparator;
import recources.generators.BandGenerator;

import java.io.IOException;
import java.util.*;

/**
 * The Receiver class contains methods for executing commands received from the user.
 */
public class Receiver {

    /**
     * Provides help information about available commands.
     *
     * @return The help information.
     */
    public static String help() {
        StringBuilder sb = new StringBuilder();
        HashMap<String, BaseCommand> table = CommandManager.getCommandMap();
        for (String key : table.keySet()) {
            sb.append(key).append(": ").append(table.get(key).getDescription()).append('\n');
        }
        return sb.toString();
    }

    /**
     * Adds a new music band to the collection.
     *
     * @return A message indicating that the element has been added to the collection.
     */
    public static String add() {
        MusicBand m1 = BandGenerator.generateBand();
        CollectionManager.add(m1.getName(), m1);
        return "Элемент был добавлен в коллекцию";
    }

    /**
     * Provides information about the collection.
     *
     * @return Information about the collection.
     */
    public static String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("Тип коллекции: \t\t\t").append(CollectionManager.getLinkedHashMap().getClass()).append('\n');
        sb.append("Дата создания: \t\t\t").append(CollectionManager.getTimeOfCreate()).append('\n');
        sb.append("Количество элементов: \t").append(CollectionManager.getLinkedHashMap().size());
        return sb.toString();
    }

    /**
     * Shows all elements of the collection.
     *
     * @return A string representation of all elements in the collection.
     */
    public static String show() {
        StringBuilder sb = new StringBuilder();
        HashMap<String, MusicBand> table = CollectionManager.getLinkedHashMap();
        for (String key : table.keySet()) {
            sb.append(CollectionManager.getLinkedHashMap().get(key)).append("\n");
        }
        if (sb.isEmpty()) {
            System.out.println("Коллекция пустая");
        }
        return sb.toString();
    }

    /**
     * Saves the collection to a file.
     *
     * @return A message indicating that the data has been saved.
     * @throws IOException     If an I/O error occurs.
     * @throws RootException   If there is an issue with the root element of the XML file.
     */
    public static String save() throws IOException, RootException {
        WriterXML.write(Console.getFile_path());
        return "Данные сохранены";
    }

    /**
     * Updates an element in the collection by its ID.
     *
     * @param sc The ID of the element to update.
     * @return A message indicating whether the element was successfully updated or not.
     */
    public static String update_by_id(String sc) {
        int currentID = 0;
        try {
            currentID = Integer.parseInt(sc);
        } catch (Exception e) {
            return "Некорректный id";
        }
        HashMap<String, MusicBand> table = CollectionManager.getLinkedHashMap();
        for (String key : table.keySet()) {
            if (currentID == table.get(key).getId()) {
                MusicBand m1 = BandGenerator.generateBand();
                m1.setId(currentID);
                CollectionManager.removeById(currentID);
                CollectionManager.add(m1.getName(), m1);
                return "Элемент был обновлен";
            }
        }
        return "Нет элемента с таким id";
    }

    /**
     * Removes an element from the collection by its ID.
     *
     * @param sc The ID of the element to remove.
     * @return A message indicating whether the element was successfully removed or not.
     */
    public static String remove_by_id(String sc) {
        int currentID = 0;
        try {
            currentID = Integer.parseInt(sc);
        } catch (Exception e) {
            return "Некорректный id";
        }
        HashMap<String, MusicBand> table = CollectionManager.getLinkedHashMap();
        for (String key : table.keySet()) {
            if (currentID == table.get(key).getId()) {
                CollectionManager.remove(key);
                return "Элемент был удален из коллекции";
            }
        }
        return "Нет элемента с таким id";
    }

    /**
     * Adds a new music band to the collection if its label sales are maximum.
     *
     * @return A message indicating whether the element was successfully added or not.
     */
    public static String addIfMax() {
        System.out.println("Предлагаем вам добавить музыкальный коллектив");
        MusicBand musibcand = BandGenerator.generateBand();
        long salesOfBand = musibcand.getLabel().getSales();
        List<MusicBand> list = new ArrayList<>();

        for (Object musicBand : CollectionManager.getLinkedHashMap().values()) {
            list.add((MusicBand) musicBand);
        }
        MusicBandComparator comparator = new MusicBandComparator();
        list.sort(comparator);

        if (salesOfBand > list.get(list.size() - 1).getLabel().getSales()) {
            CollectionManager.add(musibcand.getName(), musibcand);
            return "элемент был успешно добавлен";
        } else {
            return "элемент не был добавлен";
        }
    }

    /**
     * Adds a new music band to the collection if its label sales are minimum.
     *
     * @return A message indicating whether the element was successfully added or not.
     */
    public static String addIfMin() {
        System.out.println("Предлагаем вам добавить музыкальный коллектив");
        MusicBand musibcand = BandGenerator.generateBand();
        long salesOfBand = musibcand.getLabel().getSales();
        List<MusicBand> list = new ArrayList<>();

        for (Object musicBand : CollectionManager.getLinkedHashMap().values()) {
            list.add((MusicBand) musicBand);
        }
        MusicBandComparator comparator = new MusicBandComparator();
        list.sort(comparator);

        if (salesOfBand < list.get(0).getLabel().getSales()) {
            CollectionManager.add(musibcand.getName(), musibcand);
            return "элемент был успешно добавлен";
        } else {
            return "элемент не был добавлен";
        }
    }

    /**
     * Filters and displays music bands by name containing the specified substring.
     *
     * @param str The substring to filter by.
     * @return A message indicating that music bands containing the specified substring have been displayed.
     */
    public static String filterContainsName(String str) {
        boolean haveAnyElem = false;
        for (Object m : CollectionManager.getLinkedHashMap().values()) {
            MusicBand musicBand = (MusicBand) m;
            if (musicBand.getName().contains(str)) {
                System.out.println(m.toString());
                haveAnyElem = true;
            }
        }
        if (!haveAnyElem) {
            System.out.println("Нет музыкальных групп с указанной подстрокой в названии");
        }
        return "Все музыкальные коллективы, содержащие заданную подстроку в названии, выведены";
    }

    /**
     * Prints the label sales of music bands in ascending order.
     *
     * @return A message indicating that the label sales have been successfully printed.
     */
    public static String printFieldAscendingLabel() {
        List<MusicBand> list = new ArrayList<>();

        for (Object musicBand : CollectionManager.getLinkedHashMap().values()) {
            list.add((MusicBand) musicBand);
        }
        MusicBandComparator comparator = new MusicBandComparator();
        list.sort(comparator);

        for (MusicBand m : list) {
            System.out.println(m.getLabel().getSales());
        }
        return "Значения выручки лэйблов успешно выведены";
    }

    /**
     * Removes a music band from the collection by its label sales.
     *
     * @param salesInput The label sales of the music band to remove.
     * @return A message indicating whether the music band was successfully removed or not.
     */
    public static String removeAnyByLabel(String salesInput) {
        Integer sales;
        while (true) {
            System.out.print("Введите значение выручки лэйбла музыкальной группы, которую вы хотите удалить \n");
            try {
                Validator.isNotNullZero(salesInput);
                sales = Integer.parseInt(salesInput);
                break;
            } catch (WrongArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        List<MusicBand> list = new ArrayList<>();

        for (Object musicBand : CollectionManager.getLinkedHashMap().values()) {
            list.add((MusicBand) musicBand);
        }

        for (MusicBand m : list) {
            if (m.getLabel().getSales() == sales) {
                CollectionManager.remove(m.getName());
                return "Музыкальная группа удалена из коллекции";
            }
        }
        return "Не удалось найти музыкальную группу с таким значением выручки лэйбла";
    }
}
