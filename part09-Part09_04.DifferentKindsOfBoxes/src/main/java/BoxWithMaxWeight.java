import java.util.ArrayList;

public class BoxWithMaxWeight extends Box{
    private ArrayList<Item> box;
    private int capacity;
    
    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.box = new ArrayList<>();
    }
    
    public int totalWeight() {
        int total = 0;
        for (int i=0; i<this.box.size(); i++) {
            total += this.box.get(i).getWeight();
        }
        return total;
    }
    
    public void add(Item item) {
        if (this.totalWeight()+item.getWeight()<=this.capacity) {
            this.box.add(item);
        }
    }
    
    public boolean isInBox(Item item) {
        for (int i=0; i<this.box.size(); i++) {
            if (this.box.get(i).getName().equals(item.getName())) {
                return true;
            }
        }
        return false;
    }
}
