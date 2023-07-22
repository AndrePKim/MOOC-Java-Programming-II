package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class NotifierApplication extends Application {

    @Override
    public void start(Stage window){
        TextField text = new TextField("");
        Button button = new Button("Update");
        Label label = new Label("");
        
        button.setOnAction((event) ->  {
            label.setText(text.getText());
        });
        
        VBox group = new VBox();
        group.getChildren().addAll(text, button, label);
        
        Scene scene = new Scene(group);
        
        window.setScene(scene);
        window.show();
        
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

}
