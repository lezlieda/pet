package pro.tehnoplast;

public class Item {
    private int itemCode;
    private String itemName;
    private int itemQuantity;
    private int quotient;


    public Item(int itemCode, String itemName, int itemQuantity, int quotient) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.quotient = quotient;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getQuotient() {
        return quotient;
    }

    public void setQuotient(int quotient) {
        this.quotient = quotient;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemCode=" + itemCode +
                ", itemName='" + itemName + '\'' +
                ", quotient=" + quotient +
                ", itemQuantity=" + itemQuantity +
                '}';
    }

    public String toCSV() {
        return itemCode + "," + itemName + "," + itemQuantity;
    }

}
