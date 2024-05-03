/**
 * The ReaderXML class reads data stored in XML format.
 *
 * @see Hashtable
 * @since 1.0
 */
package filelogic;

import exceptions.WrongArgumentException;
import managers.CollectionManager;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import recources.Coordinates;
import recources.Label;
import recources.MusicBand;
import recources.MusicGenre;
import system.Validator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Hashtable;

public class ReaderXML {

    /**
     * Reads data from the file into the collection.
     *
     * @param path the path to the file
     * @throws Exception if an error occurs
     * @see CollectionManager
     */
    public static void read(String path) {
        File file = new File(path);
        if (!file.canRead() || !file.canWrite()) {
            System.out.println("Insufficient permissions to work with the file");
            System.exit(1);
        }
        try {
            // Reading from the file
            var br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
            String line;
            StringBuilder text = new StringBuilder();
            while ((line = br.readLine()) != null) {
                text.append(line);
            }
            if (text.isEmpty()) {
                System.out.println("No element to add, your collection is clear");
                return;
            }

            InputSource in = new InputSource(new StringReader(text.toString()));

            // Obtaining the factory to get the document builder.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Obtaining the builder from the factory, which parses XML and creates a Document structure in the form of a hierarchical tree.
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parsing XML, creating a Document structure. Now we have access to all elements as we need.
            Document document = builder.parse(in);


            NodeList organisationElements = document.getDocumentElement().getElementsByTagName("musicband");

            if (organisationElements.getLength() == 0) {
                System.out.println("Empty file");
                return;
            }

            // Iterating over all elements of music band
            for (int i = 0; i < organisationElements.getLength(); i++) {
                Node musicBand = organisationElements.item(i);

                // Getting the attributes of each element
                NamedNodeMap attributes = musicBand.getAttributes();
                String[] data = new String[]{attributes.getNamedItem("id").getNodeValue(), attributes.getNamedItem("name").getNodeValue(),
                        attributes.getNamedItem("coordinates_x").getNodeValue(), attributes.getNamedItem("coordinates_y").getNodeValue(),
                        attributes.getNamedItem("creationDate").getNodeValue(), attributes.getNamedItem("numberOfParticipants").getNodeValue(),
                        attributes.getNamedItem("albumsCount").getNodeValue(),
                        attributes.getNamedItem("genre").getNodeValue(), attributes.getNamedItem("label_sales").getNodeValue()};
                String key = data[1];

                Validator.isNotNull(data[0]);
                Validator.isNotNull(data[1]);
                Validator.XisCorrect(data[2]);
                Validator.YisCorrect(data[3]);
                Validator.isNotNullZero(data[5]);
                Validator.isNotNullZero(data[6]);
                Validator.isNotNullZero(data[8]);

                MusicBand m1 = new MusicBand(Integer.parseInt(data[0]), data[1], new Coordinates(Float.parseFloat(data[2]),
                        Float.parseFloat(data[3])),
                        LocalDateTime.parse(data[4]), Integer.parseInt(data[5]),
                        Integer.parseInt(data[6]),
                        MusicGenre.valueOf(data[7]), new Label(Integer.parseInt(data[8])));
                CollectionManager.add(key, m1);
            }
            System.out.println("Data from the file received");
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("There was a problem with the file");
            System.exit(1);
        } catch (WrongArgumentException e) {
            System.out.println("There was a problem with the data of the elements");
            System.exit(1);
        }
    }
}
