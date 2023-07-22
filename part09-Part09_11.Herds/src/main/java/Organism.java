
public class Organism implements Movable{
    private int dx;
    private int dy;
    
    public Organism(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
    
    public void move(int dx, int dy) {
        this.dx += dx;
        this.dy += dy;
    }
    
    public String toString() {
        return "x: " + this.dx + "; y: " + this.dy;
    }
}
