import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand implements Comparable<Hand>{
    private ArrayList<Card> cards;
    
    public Hand() {
        this.cards = new ArrayList<>();
    }
    
    public void add(Card card) {
        this.cards.add(card);
    }
    
    public void print() {
        for (int i=0; i<this.cards.size(); i++) {
            System.out.println(this.cards.get(i));
        }
    }
    
    public void sort() {
        Comparator<Card> comparator = Comparator
                .comparing(Card::getValue)
                .thenComparing(Card::getSuit);
        
        Collections.sort(cards, comparator);
    }
    
    public int compareTo(Hand hand) {
        int handvalue = 0;
        int comparevalue = 0;
        for (int i=0; i<this.cards.size(); i++) {
            handvalue += this.cards.get(i).getValue();
        }
        for (int i=0; i<hand.cards.size(); i++) {
            comparevalue += hand.cards.get(i).getValue();
        }
        return handvalue - comparevalue;
    }
    
    public void sortBySuit() {
        Collections.sort(cards, new BySuitInValueOrder());
    }
}
