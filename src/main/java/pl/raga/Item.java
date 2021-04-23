package pl.raga;

public class Item {

    private final String name;
    private int quantity;
    //private int price;

    public Item(String name) {
        this.name = name;
        this.quantity = 1;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

   // public int getPrice() {
   //     return price;
  //  }
}
