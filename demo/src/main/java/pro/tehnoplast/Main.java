package pro.tehnoplast;



public class Main {
    public static void main(String[] args) {
        System.out.println("Введите путь к сводной таблице:");
        String path = new java.util.Scanner(System.in).nextLine();
        XlsxParser.createOrder(path);

    }
}