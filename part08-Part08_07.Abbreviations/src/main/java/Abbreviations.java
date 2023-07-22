import java.util.HashMap;

public class Abbreviations {
    private HashMap<String,String> abb;
    
    public Abbreviations() {
        this.abb = new HashMap<>();
    }
    
    public void addAbbreviation(String abbreviation, String explanation) {
        if (abbreviation==null) {
            abbreviation = "";
        }
        abbreviation.toLowerCase();
        abbreviation.trim();
        if (this.abb.containsKey(abbreviation)) {
            System.out.println("Book is already in the library!");
        } else {
            this.abb.put(abbreviation, explanation);
        }
    }
    
    public boolean hasAbbreviation(String abbreviation) {
        if (this.abb.containsKey(abbreviation)) {
            return true;
        } else {
            return false;
        }
    }
    
    public String findExplanationFor(String abbreviation) {
        if (this.abb.containsKey(abbreviation)) {
            return this.abb.get(abbreviation);
        } else {
            return null;
        }
    }
}
