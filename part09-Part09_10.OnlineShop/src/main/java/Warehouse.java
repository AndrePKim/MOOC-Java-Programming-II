import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Warehouse {
    private Map<String,Integer> price;
    private Map<String,Integer> stock;
    
    public Warehouse() {
        this.price = new HashMap<>();
        this.stock = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        this.price.put(product, price);
        this.stock.put(product, stock);
    }
    
    public int price(String product) {
        if (this.price.containsKey(product)) {
            return this.price.get(product);
        }
        return -99;
    }
    
    public int stock(String product) {
        if (this.stock.containsKey(product)) {
            return this.stock.get(product);
        }
        return 0;
    }
    
    public boolean take(String product) {
        if (this.stock.containsKey(product)) {
            if (this.stock.get(product)==0) {
                return false;
            }
            this.stock.replace(product, this.stock.get(product)-1);
            return true;
        }
        return false;
    }
    
    public Set<String> products() {
        Set<String> product = new HashSet<>();
        for (String name: this.price.keySet()) {
            product.add(name);
        }
        return product;
    }
}
