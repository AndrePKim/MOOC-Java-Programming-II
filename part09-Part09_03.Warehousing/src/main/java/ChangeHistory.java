import java.util.ArrayList;

public class ChangeHistory {
    private ArrayList<Double> history;
    
    public ChangeHistory() {
        this.history = new ArrayList<>();
    }
    
    public void add(double status) {
        this.history.add(status);
    }
    
    public void clear() {
        this.history.clear();
    }
    
    public String toString() {
        return this.history.toString();
    }
    
    public double maxValue() {
        double num = 0;
        for (int i=0; i<this.history.size(); i++) {
            if (this.history.get(i)>num) {
                num = this.history.get(i);
            }
        }
        return num;
    }
    
    public double minValue() {
        double num = 999;
        for (int i=0; i<this.history.size(); i++) {
            if (this.history.get(i)<num) {
                num = this.history.get(i);
            }
        }
        return num;
    }
    
    public double average() {
        double sum = 0;
        for (int i=0; i<this.history.size(); i++) {
            sum += this.history.get(i);
        }
        return sum/this.history.size();
    }
}
