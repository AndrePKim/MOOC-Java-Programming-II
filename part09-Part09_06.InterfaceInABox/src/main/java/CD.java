
public class CD implements Packable{
    private String artist;
    private String CDName;
    private int publicationYear;
    
    public CD(String artist, String CDName, int publicationYear) {
        this.artist = artist;
        this.CDName = CDName;
        this.publicationYear = publicationYear;
    }
    
    public double weight() {
        return 0.1;
    }
    
    public String toString() {
        return this.artist + ": " + this.CDName + " (" + this.publicationYear + ")";
    }
    
}
