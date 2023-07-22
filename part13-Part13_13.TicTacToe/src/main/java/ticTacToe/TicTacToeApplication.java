package ticTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import javafx.scene.text.Font;

public class TicTacToeApplication extends Application {
    
    private Button[] board = new Button[9];
    private String symbol = "X";
    private Label message = new Label("Turn: X");
    private Boolean end = false;
    
    public TicTacToeApplication() {
        for (int i=0; i<9; i++) {
            board[i] = makebutton();
        }
    }
    
    @Override
    public void start(Stage stage){
        
        BorderPane layout = new BorderPane();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        message.setFont(Font.font("Monospaced", 40));
        
        grid.add(board[0], 0, 0);
        grid.add(board[1], 0, 1);
        grid.add(board[2], 0, 2);
        grid.add(board[3], 1, 0);
        grid.add(board[4], 1, 1);
        grid.add(board[5], 1, 2);
        grid.add(board[6], 2, 0);
        grid.add(board[7], 2, 1);
        grid.add(board[8], 2, 2);
        
        layout.setTop(message);
        layout.setCenter(grid);
        
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }
    
    public Button makebutton() {
        Button button = new Button("");
        button.setMinSize(80, 80);
        button.setMaxSize(80, 80);
        button.setFont(Font.font("Monospaced", 40));
        button.setOnAction((start) -> {
            if (end==false) {
                if (!button.getText().equals("")) {
                    return;
                }
                if (symbol.equals("X")) {
                    button.setText("X");
                    this.symbol = "O";
                    message.setText("Turn: " + this.symbol);
                } else if (symbol.equals("O")) {
                    button.setText("O");
                    this.symbol = "X";
                    message.setText("Turn: " + this.symbol);
                }
            }
            if (hcheck("X")==true || vcheck("X")==true || dcheck("X")==true || hcheck("O")==true || vcheck("O")==true || dcheck("O")==true) {
                end = true;
            } else {
                end = fullGrid();
            }
            if (end==true) {
                message.setText("The end!");
            }
        });
        return button;
    }
    
    public boolean hcheck(String string) {
        if (board[0].getText().equals(string) && board[1].getText().equals(string) && board[2].getText().equals(string)) {
            return true;
        } else if (board[3].getText().equals(string) && board[4].getText().equals(string) && board[5].getText().equals(string)) {
            return true;
        } else if (board[6].getText().equals(string) && board[7].getText().equals(string) && board[8].getText().equals(string)) {
            return true;
        }
        return false;
    }
    
    public boolean vcheck(String string) {
        if (board[0].getText().equals(string) && board[3].getText().equals(string) && board[6].getText().equals(string)) {
            return true;
        } else if (board[1].getText().equals(string) && board[4].getText().equals(string) && board[7].getText().equals(string)) {
            return true;
        } else if (board[2].getText().equals(string) && board[5].getText().equals(string) && board[8].getText().equals(string)) {
            return true;
        }
        return false;
    }
    
    public boolean dcheck(String string) {
        if (board[0].getText().equals(string) && board[4].getText().equals(string) && board[8].getText().equals(string)) {
            return true;
        } else if (board[2].getText().equals(string) && board[4].getText().equals(string) && board[6].getText().equals(string)) {
            return true;
        }
        return false;
    }
    
    public boolean fullGrid() {
        int count = 0;
        for (int i=0; i<9; i++) {
            if (board[i].getText().isEmpty()) {
                count++;
            }
        }
        if (count==0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
