package pl.raga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {
    private List<Item> itemList = new ArrayList<>();
    private List<Rule> ruleList;
    private Map<String, Double> prices = new HashMap<>();

    public Shop() {
        ruleList = new ArrayList<>();
        ruleList.add(new Rule("A", 3, 130.00));
        ruleList.add(new Rule("B", 2, 45.00));
        prices.put("A",50.00);
        prices.put("B",30.00);
        prices.put("C",20.00);
        prices.put("D",15.00);
    }

    public Shop(List<Rule> ruleList, Map<String, Double> prices) {
        this.ruleList = ruleList;
        this.prices = prices;
    }

    public Double total() {
        Double totalPrice = 0.0;

        for(Item item: itemList){
            Double itemPrice = prices.get(item.getName());
            //if(itemPrice != null) {
                totalPrice += itemPrice * item.getQuantity();

                for (Rule r : ruleList) {
                    if (r.getItemName().equals(item.getName())) {
                        if (item.getQuantity() >= r.getQuantity()) { //discount applied
                            Double discount = (item.getQuantity() / r.getQuantity()) * (itemPrice * r.getQuantity() - r.getPrice());
                            totalPrice -= discount;
                        }
                    }
                }
            //}
        }
        return totalPrice;
    }

    public void scan(String itemName) {
        if (!itemName.equals("")) {
            if (itemList.isEmpty() || !containsName(itemList, itemName)) {
                if(prices.get(itemName) != null) {
                    Item item = new Item(itemName);
                    itemList.add(item);
                } else throw new IllegalArgumentException("Not existing promotion code");
            } else {
                for (Item i : itemList) {
                    if (i.getName().equals(itemName)) {
                        i.setQuantity(i.getQuantity() + 1);
                    }
                }
            }
        }
    }

    public Double price(String goods) {
        String[] itemNames=goods.split("");
        for(String s: itemNames) {
            scan(s);
        }
        return total();
    }

    private boolean containsName(List<Item> itemList, String itemName) {
        //return itemList.stream().filter(o -> o.getName().equals(itemName)).findFirst().isPresent();
        return itemList.stream().anyMatch(o -> o.getName().equals(itemName));
    }
}
