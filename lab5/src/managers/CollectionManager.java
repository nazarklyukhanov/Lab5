/**
 * The CollectionManager class manages the collection of MusicBand objects.
 */
package managers;

import recources.MusicBand;

import java.time.LocalDate;
import java.util.LinkedHashMap;

public class CollectionManager {
    private static LinkedHashMap<String, MusicBand> musicBandLinkedHashMap = new LinkedHashMap<>();
    private static LocalDate TimeOfCreate = LocalDate.now();

    /**
     * Adds a MusicBand object to the collection.
     *
     * @param key       the key associated with the MusicBand object
     * @param musicBand the MusicBand object to add
     */
    public static void add(String key, MusicBand musicBand) {
        musicBandLinkedHashMap.put(key, musicBand);
    }

    /**
     * Returns the LinkedHashMap representing the collection.
     *
     * @return the LinkedHashMap representing the collection
     */
    public static LinkedHashMap getLinkedHashMap() {
        return musicBandLinkedHashMap;
    }

    /**
     * Returns the time when the collection was created.
     *
     * @return the time of collection creation
     */
    public static LocalDate getTimeOfCreate() {
        return TimeOfCreate;
    }

    /**
     * Removes a MusicBand object from the collection by its key.
     *
     * @param key the key associated with the MusicBand object to remove
     */
    public static void remove(String key) {
        MusicBand.removeId(musicBandLinkedHashMap.get(key).getId());
        musicBandLinkedHashMap.remove(key);
    }

    /**
     * Removes a MusicBand object from the collection by its ID.
     *
     * @param id the ID of the MusicBand object to remove
     */
    public static void removeById(int id) {
        for (String key : musicBandLinkedHashMap.keySet()) {
            if (musicBandLinkedHashMap.get(key).getId() == id) {
                MusicBand.removeId(musicBandLinkedHashMap.get(key).getId());
                musicBandLinkedHashMap.remove(key);
                return;
            }
        }
        System.out.println("The element was not found");
    }
}
