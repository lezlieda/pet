package pro.tehnoplast;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.File;

import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        LinksReader linksReader = new LinksReader();
        List<String> links = linksReader.getLinks();
        for (String link : links) {
            System.out.println(link);
        }

        Set<String> xlsxs = getXlsxFilenames("target/classes/");
        for (String xlsx : xlsxs) {
            System.out.println(xlsx);
        }

        new App().readXlsx(xlsxs.iterator().next());


    }

    private void readXlsx(String filename) {
        try {
            DataFormatter dataFormatter = new DataFormatter();
            Sheet sheet = new XSSFWorkbook(new FileInputStream("target/classes/" + filename)).getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    String cellValue = dataFormatter.formatCellValue(cell);
                    System.out.print(cellValue + "\t");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}



    public static Set<String> getXlsxFilenames(String dir) {
        return new App().listFilesUsingJavaIO(dir).stream()
            .filter(file -> file.endsWith(".xlsx") && !file.startsWith("~$"))
            .collect(Collectors.toSet());
    }

    public Set<String> listFilesUsingJavaIO(String dir) {
        return Stream.of(new File(dir).listFiles())
            .filter(file -> !file.isDirectory())
            .map(File::getName)
            .collect(Collectors.toSet());
    }
}
