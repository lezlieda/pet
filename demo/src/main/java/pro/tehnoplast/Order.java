package pro.tehnoplast;

public class Order {
    private String destination;
    private String orderNumber;
    private double orderAmount;
    private String orderDate;
    private Item[] items;

    public Order() {
    }

    public Order(String destination, String orderNumber, double orderAmount, String orderDate, Item[] items) {
        this.destination = destination;
        this.orderNumber = orderNumber;
        this.orderAmount = orderAmount;
        this.orderDate = orderDate;
        this.items = items;
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

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Item[] getItems() {
        return items;
    }

    public void addItem(Item item) {
        Item[] newItems = new Item[items.length + 1];
        System.arraycopy(items, 0, newItems, 0, items.length);
        newItems[items.length] = item;
        items = newItems;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{");
        sb.append("destination='").append(destination).append('\'');
        sb.append(", orderNumber='").append(orderNumber).append('\'');
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", orderDate='").append(orderDate).append('\'');
        sb.append(", items=[");
        for (Item item : items) {
            sb.append(item).append(", ");
        }
        sb.append("]}");
        return sb.toString();
    }
}
