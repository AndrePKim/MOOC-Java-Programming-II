import java.util.Map;
import java.util.HashMap;

public class ShoppingCart {
    private Map<String,Item> cart;
    
    public ShoppingCart() {
        this.cart = new HashMap<>();
    }
    
    public void add(String product, int price) {
        if (this.cart.containsKey(product)) {
            this.cart.get(product).increaseQuantity();
        } else {
            this.cart.put(product, new Item(product,1,price));
        }
    }
    
    public int price() {
        int sum = 0;
        for (String name: this.cart.keySet()) {
            sum += this.cart.get(name).price();
        }
        return sum;
    }
    
    public void print() {
        for (String name: this.cart.keySet()) {
            System.out.println(this.cart.get(name));
        }
    }
    
}
