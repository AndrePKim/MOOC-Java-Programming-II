
package dictionary;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;

public class SaveableDictionary {
    private ArrayList<String> word;
    private ArrayList<String> translation;
    private String file;
    
    public SaveableDictionary() {
        this.word = new ArrayList<>();
        this.translation = new ArrayList<>();
    }
    
    public SaveableDictionary(String file) {
        this.word = new ArrayList<>();
        this.translation = new ArrayList<>();
        this.file = file;
    }
    
    public void add(String words, String translation) {
        if (!this.word.contains(words)) {
            this.word.add(words);
            this.translation.add(translation);
        }
    }
    
    public String translate(String word) {
        for (int i=0; i<this.word.size(); i++) {
            if (this.word.get(i).equals(word)) {
                return this.translation.get(i);
            } else if (this.translation.get(i).equals(word)) {
                return this.word.get(i);
            }
        }
        return null;
    }
    
    public void delete(String word) {
        for (int i=0; i<this.word.size(); i++) {
            if (this.word.get(i).equals(word)) {
                this.word.remove(i);
                this.translation.remove(i);
            } else if (this.translation.get(i).equals(word)) {
                this.word.remove(i);
                this.translation.remove(i);
            }
        }
    }
    
    public boolean load() {
        try (Scanner scanner = new Scanner(Paths.get(this.file))) {
            while (scanner.hasNextLine()) {
                String fill = scanner.nextLine();
                String[] parts = fill.split(":");
                this.word.add(parts[0]);
                this.translation.add(parts[1]);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(this.file);
            for (int i=0; i<this.word.size(); i++) {
                writer.println(this.word.get(i) + ":" + this.translation.get(i));
            }
            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
