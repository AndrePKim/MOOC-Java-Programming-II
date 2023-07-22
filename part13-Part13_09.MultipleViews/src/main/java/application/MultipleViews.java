package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;

public class MultipleViews extends Application{

    @Override
    public void start(Stage window) {
        BorderPane first = new BorderPane();
        Button tosecond = new Button("To the second view!");
        first.setTop(new Label("First view!"));
        first.setCenter(tosecond);
        
        VBox second = new VBox();
        second.setSpacing(0);
        Button tothird = new Button("To the third view!");
        second.getChildren().add(tothird);
        second.getChildren().add(new Label("Second View!"));
        
        GridPane third = new GridPane();
        Button tofirst = new Button("To the first view!");
        third.add(new Label("Third view!"), 0, 0);
        third.add(tofirst, 1, 1);
        
        Scene scene1 = new Scene(first);
        Scene scene2 = new Scene(second);
        Scene scene3 = new Scene(third);
        
        tosecond.setOnAction((event) -> {
            window.setScene(scene2);
        });
        
        tothird.setOnAction((event) -> {
            window.setScene(scene3);
        });
        
        tofirst.setOnAction((event) -> {
            window.setScene(scene1);
        });

        window.setScene(scene1);
        window.show();
    }

    
    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

}
