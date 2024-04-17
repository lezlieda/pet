package pro.tehnoplast;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.Iterator;

public class XlsxParser {
    public static void readXlsx(String path) {
        try (FileInputStream fis = new FileInputStream(path);
             Workbook wb = new XSSFWorkbook(fis)) {
            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Order[] createOrders(String path) {
        try (FileInputStream fis = new FileInputStream(path);
             Workbook wb = new XSSFWorkbook(fis)) {
            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row = rowIterator.next();
            int columnCount = row.getLastCellNum();
            Order[] orders = new Order[columnCount - 5];
            String ordersDate = row.getCell(1).toString();
            String[] destinations = new String[columnCount - 5];
            for (int i = 4; i < columnCount - 1; i++) {
                destinations[i - 4] = row.getCell(i).toString();
                orders[i - 4] = new Order();
                orders[i - 4].setDestination(destinations[i - 4]);
                orders[i - 4].setOrderDate(ordersDate);
            }
            String[] orderNumbers = new String[columnCount - 5];
            row = rowIterator.next();
            for (int i = 4; i < columnCount - 1; i++) {
                orderNumbers[i - 4] = row.getCell(i).toString();
                orders[i - 4].setOrderNumber(orderNumbers[i - 4]);
            }
            row = rowIterator.next();
            double[] orderSums = new double[columnCount - 5];
            for (int i = 4; i < columnCount - 1; i++) {
                orderSums[i - 4] = Double.parseDouble(row.getCell(i).toString());
                orders[i - 4].setOrderSum(orderSums[i - 4]);
            }
            row = rowIterator.next();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                if (row.getCell(0) == null) {
                    break;
                }
                for (int i = 4; i < columnCount - 1; i++) {
                    if (row.getCell(i).toString() != "") {
                        int itemCode = (int) Double.parseDouble(row.getCell(0).toString());
                        String itemName = row.getCell(1).toString();
                        int itemQuantity = (int) Double.parseDouble(row.getCell(i).toString());
                        int quotient = (int) Double.parseDouble(row.getCell(3).toString());
                        Item item = new Item(itemCode, itemName, itemQuantity, quotient);
                        orders[i - 4].addItem(item);


                    }
                }
            }
            row = rowIterator.next();
            row = rowIterator.next();
            for (int i = 4; i < columnCount - 1; i++) {
                orders[i - 4].setInvoiceNumber((int) Double.parseDouble(row.getCell(i).toString()));
            }
            return orders;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
