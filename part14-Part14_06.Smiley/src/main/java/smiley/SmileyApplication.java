package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SmileyApplication extends Application{

    public void start(Stage window) {
        Canvas paintingCanvas = new Canvas(400, 400);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();

        BorderPane paintingLayout = new BorderPane();
        paintingLayout.setCenter(paintingCanvas);
        
        painter.setFill(Color.BLACK);
        painter.fillRect(100, 50, 50, 50);
        painter.fillRect(250, 50, 50, 50);
        painter.fillRect(50, 250, 50, 50);
        painter.fillRect(300, 250, 50, 50);
        painter.fillRect(100, 300, 200, 50);

        Scene view = new Scene(paintingLayout, Color.WHITE);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

}
