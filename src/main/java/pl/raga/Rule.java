package pl.raga;

public class Rule {
    private String itemName;
    private String ruleName;
    private int quantity;
    private Double price;

    public Rule(String itemName, String ruleName) {
        this.itemName = itemName;
        this.ruleName = ruleName;
        this.quantity = Integer.parseInt(ruleName.split(" ")[0]);
        this.price = Double.parseDouble(ruleName.split(" ")[2]);
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