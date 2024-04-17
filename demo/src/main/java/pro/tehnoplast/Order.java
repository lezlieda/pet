package pro.tehnoplast;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String destination;
    private String orderNumber;
    private double orderSum;
    private String orderDate;
    private List<Item> items = new ArrayList<>();
    private int invoiceNumber;

    public Order() {
    }

    public Order(String destination, String orderNumber, double orderSum, String orderDate) {
        this.destination = destination;
        this.orderNumber = orderNumber;
        this.orderSum = orderSum;
        this.orderDate = orderDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(double orderSum) {
        this.orderSum = orderSum;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{");
        sb.append("destination='").append(destination).append('\'');
        sb.append(", orderNumber='").append(orderNumber).append('\'');
        sb.append(", orderSum=").append(orderSum);
        sb.append(", orderDate='").append(orderDate).append('\'');
        sb.append(", items=[");
        for (Item item : items) {
            sb.append(item.toString()).append(", ");
        }
        sb.append("], invoiceNumber=").append(invoiceNumber);
        sb.append("}");
        return sb.toString();
    }
}
