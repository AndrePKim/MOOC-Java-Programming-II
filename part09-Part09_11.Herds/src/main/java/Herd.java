import java.util.ArrayList;

public class Herd implements Movable{
    private ArrayList<Movable> herd;
    
    public Herd() {
        this.herd = new ArrayList<>();
    }
    
    public String toString() {
        String fill = "";
        for (int i=0; i<this.herd.size(); i++) {
            fill = fill + "\n" + this.herd.get(i).toString();
        }
        return fill;
    }
    
    public void move(int dx, int dy) {
        for (int i=0; i<this.herd.size(); i++) {
            this.herd.get(i).move(dx, dy);
        }
    }
    
    public void addToHerd(Movable movable) {
        this.herd.add(movable);
    }
}
