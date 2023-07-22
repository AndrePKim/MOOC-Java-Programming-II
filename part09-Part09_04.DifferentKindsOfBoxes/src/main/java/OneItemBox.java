
public class OneItemBox extends Box{
    private String item = "";
    
    public OneItemBox() {
    }
    
    public void add(Item item) {
        if (this.item.equals("")) {
            this.item = item.getName();
        }
    }
    
    public boolean isInBox(Item item) {
        if (this.item.equals(item.getName())) {
            return true;
        }
        return false;
    }
}
