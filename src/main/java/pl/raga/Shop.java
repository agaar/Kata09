package pl.raga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {
    private List<Item> itemList;
    private List<Rule> ruleList;
    private Map<String, Double> prices = new HashMap<>();

    public Shop() {
        itemList = new ArrayList<>();
        ruleList = new ArrayList<>();
        ruleList.add(new Rule("A", "3 for 130"));
        ruleList.add(new Rule("B", "2 for 45"));
        prices.put("A",50.00);
        prices.put("B",30.00);
        prices.put("C",20.00);
        prices.put("D",15.00);
    }

    public Double total() {
        Double totalPrice = 0.0;

        for(Item item: itemList){ //AB
            totalPrice += prices.get(item.getName())*item.getQuantity();

            for(Rule r : ruleList) { //A
                if(r.getItemName().equals(item.getName())){
                    if (item.getQuantity()>=r.getQuantity() ) {
                        Double itemPrice = prices.get(item.getName());
                        //Double beforeDiscount = item.getQuantity()*itemPrice;
                        //Double normalPrice =(item.getQuantity()%r.getQuantity())*itemPrice;
                        //Double discountedPrice = (item.getQuantity()/r.getQuantity())*r.getPrice();
                        //Double newPrice = normalPrice + discountedPrice;

                        Double discount = (item.getQuantity()/r.getQuantity())*(itemPrice*r.getQuantity() - r.getPrice());
                        totalPrice -= discount;
                    }
                }
            }
        }
        return totalPrice;
    }

    public void scan(String itemName) {
        if (!itemName.equals("")) {
            if (itemList.isEmpty() || !containsName(itemList, itemName)) {
                Item item = new Item(itemName);
                itemList.add(item);
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
        //Double totalPrice = 0.0;
        for(String s: itemNames) {
            scan(s);
        }
        return total();
    }


    public List<Rule> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<Rule> ruleList) {
        this.ruleList = ruleList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public Map<String, Double> getPrices() {
        return prices;
    }

    public void setPrices(Map<String, Double> prices) {
        this.prices = prices;
    }

    private boolean containsName(List<Item> itemList, String itemName) {
        return itemList.stream().filter(o -> o.getName().equals(itemName)).findFirst().isPresent();
    }
}
