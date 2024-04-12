package pro.tehnoplast;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reads links from a file.
 */
public class LinksReader {
    private static final String FILE_NAME = "target//classes//links.txt";
    private static List<String> links = null;

    public LinksReader() {
        links = new ArrayList<>();
        try (FileReader fileReader = new FileReader(FILE_NAME)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                links.add(scanner.nextLine());
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> getLinks() {
        return links;
    }


}
