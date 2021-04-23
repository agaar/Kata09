package pl.raga;

public class Rule {
    private String itemName;
    private int quantity;
    private Double price;


    public Rule(String itemName, int quantity, Double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

}