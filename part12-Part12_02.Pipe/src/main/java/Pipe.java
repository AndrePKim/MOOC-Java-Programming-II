import java.util.ArrayList;

public class Pipe<T> {
    private ArrayList<T> object = new ArrayList<>();
    
    public void putIntoPipe(T value) {
        this.object.add(value);
    }
    
    public T takeFromPipe() {
        T fill = this.object.get(0);
        this.object.remove(0);
        return fill;
    }
    
    public boolean isInPipe() {
        if (this.object.size()==0) {
            return false;
        }
        return true;
    }
}
