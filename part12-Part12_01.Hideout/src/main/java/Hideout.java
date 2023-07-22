
public class Hideout<T> {
    private T object;
    
    public void putIntoHideout(T toHide) {
        this.object = toHide;
    }
    
    public T takeFromHideout() {
        if (this.object==null) {
            return null;
        }
        T fill;
        fill = this.object;
        this.object = null;
        return fill;
    }
    
    public boolean isInHideout() {
        if (this.object==null) {
            return false;
        }
        return true;
    }
}
