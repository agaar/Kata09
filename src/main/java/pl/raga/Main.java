package pl.raga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println("Main");
        Shop shop = new Shop();
       /* Map<String, Double> map = new HashMap<>();
        map.put("A",50.00);

        shop.setPrices(map);
        shop.scan("A");
        shop.scan("A");
        shop.scan("B");
        shop.scan("C");
        shop.scan("D");
        shop.total();

        Rule rule = new Rule("A", "3for130");
        Rule rule2 = new Rule("A", "2for45");
        List<Rule> rules = new ArrayList<>();
        rules.add(rule);
        rules.add(rule2);
*/
        shop.price("A");

    }
}
