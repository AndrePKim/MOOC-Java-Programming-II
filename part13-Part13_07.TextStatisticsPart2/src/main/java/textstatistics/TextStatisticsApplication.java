package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Arrays;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        TextArea textbox = new TextArea("");
        Label letters = new Label("");
        Label words = new Label("");
        Label longest = new Label("");
        
        textbox.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int wordl = parts.length;
            String longestl = Arrays.stream(parts)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .get();

            letters.setText("Letters: " + characters);
            words.setText("Words: " + wordl);
            longest.setText("The longest word is: " + longestl);
        });
        
        HBox text = new HBox();
        text.setSpacing(10);
        text.getChildren().add(letters);
        text.getChildren().add(words);
        text.getChildren().add(longest);

        layout.setBottom(text);
        layout.setCenter(textbox);

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
