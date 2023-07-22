
public class ProductWarehouseWithHistory extends ProductWarehouse{
    private ChangeHistory history = new ChangeHistory();
    
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        this.history.add(initialBalance);
    }
    
    public void addToWarehouse(double amount) {
        if (amount < 0) {
            return;
        }
        double num = super.getBalance() + amount;
        this.history.add(num);
        super.addToWarehouse(amount);
    }
    
    public double takeFromWarehouse(double amount) {
        if (amount < 0) {
            return 0.0;
        }
        double num = super.getBalance() - amount;
        this.history.add(num);
        return super.takeFromWarehouse(amount);
    }
    
    public void printAnalysis() {
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + this.history());
        System.out.println("Largest amount of product: " + this.history.maxValue());
        System.out.println("Smallest amount of product: " + this.history.minValue());
        System.out.println("Average: " + this.history.average());
    }
    
    public String history() {
        return this.history.toString();
    }
}
