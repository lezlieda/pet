package pro.tehnoplast;



public class Main {
    public static void main(String[] args) {
        System.out.println("Введите путь к сводной таблице:");
        String path = new java.util.Scanner(System.in).nextLine();
        Order[] orders = XlsxParser.createOrders(path);
        for (Order o : orders) {
            System.out.println(o.toString());

        }

    }
}