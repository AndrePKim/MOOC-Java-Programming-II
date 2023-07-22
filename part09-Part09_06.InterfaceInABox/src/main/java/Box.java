import java.util.ArrayList;

public class Box implements Packable {
    private double capacity;
    private ArrayList<Packable> box;
    
    public Box(double capacity) {
        this.capacity = capacity;
        this.box = new ArrayList<>();
    }
    
    public void add(Packable item) {
        if (item.weight()+this.weight()<=10) {
            this.box.add(item);
        }
    }
    
    public double weight() {
        double sum = 0;
        for (int i=0; i<this.box.size(); i++) {
            sum += this.box.get(i).weight();
        }
        return sum;
    }
    
    public String toString() {
        return "Box: " + this.box.size() + " items, total weight " + this.weight() + " kg";
    }
}
