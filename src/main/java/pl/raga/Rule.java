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

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}