import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Employees {
    private ArrayList<Person> list;
    
    public Employees() {
        this.list = new ArrayList<>();
    }
    
    public void add(Person personToAdd) {
        this.list.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd) {
        for (int i=0; i<peopleToAdd.size(); i++) {
            this.list.add(peopleToAdd.get(i));
        }
    }
    
    public void print() {
        Iterator<Person> iterator = list.iterator();
        
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
    }
    
    public void print(Education education) {
        Iterator<Person> iterator = list.iterator();
        
        while(iterator.hasNext()) {
            Person next = iterator.next();
            if (next.getEducation().equals(education)) {
                System.out.println(next);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> iterator = list.iterator();
        
        while(iterator.hasNext()) {
            if (iterator.next().getEducation().equals(education)) {
                iterator.remove();
            }
        }
    }
}
