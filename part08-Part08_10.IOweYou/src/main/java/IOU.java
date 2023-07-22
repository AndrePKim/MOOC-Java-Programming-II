import java.util.HashMap;

public class IOU {
    private HashMap<String,Double> debt;
    
    public IOU() {
        this.debt = new HashMap<>();
    }
    
    public void setSum(String toWhome, double amount) {
        this.debt.put(toWhome, amount);
    }
    
    public double howMuchDoIOweTo(String toWhom) {
        return this.debt.getOrDefault(toWhom, 0.0);
    }
}
