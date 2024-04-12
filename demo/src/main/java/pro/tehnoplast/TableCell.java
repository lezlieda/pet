package pro.tehnoplast;

public class TableCell {
    private int id;
    private String name;
    private int quantity;

    public TableCell(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

}
