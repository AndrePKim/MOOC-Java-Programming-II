package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {
    
    @Override
    public void start(Stage window) {
        Button button = new Button("This is a button");
        Label text = new Label("Text element");
        
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(text);
        componentGroup.getChildren().add(button);
        
        Scene view = new Scene(componentGroup);
        
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

}
