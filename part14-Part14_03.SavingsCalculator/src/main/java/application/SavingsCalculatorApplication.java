package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import java.util.ArrayList;

public class SavingsCalculatorApplication extends Application{
    
    @Override
    public void start(Stage stage) {
        // Month BorderPane in VBox
        BorderPane monthLayout = new BorderPane();
        monthLayout.setLeft(new Label("Monthly savings"));
        
        Slider monthSlider = new Slider(25, 250, 25);
        monthSlider.setShowTickMarks(true);
        monthSlider.setShowTickLabels(true);
        monthSlider.setSnapToTicks(true);
        monthSlider.setBlockIncrement(500);
        
        Label monthSliderValue = new Label("" + monthSlider.getValue());
        monthLayout.setCenter(monthSlider);
        monthLayout.setRight(monthSliderValue);
        
        // Year BorderPane in VBox
        BorderPane yearLayout = new BorderPane();
        yearLayout.setLeft(new Label("Yearly interest rate"));
        
        Slider yearSlider = new Slider(0, 10, 0);
        yearSlider.setShowTickMarks(true);
        yearSlider.setShowTickLabels(true);
        yearSlider.setMajorTickUnit(10);
        yearSlider.setMinorTickCount(4);
        
        Label yearSliderValue = new Label("" + yearSlider.getValue());
        yearLayout.setCenter(yearSlider);
        yearLayout.setRight(yearSliderValue);
        
        //LineChart for Savings
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings calculator");

        XYChart.Series saving = new XYChart.Series();
        for (int i=0; i<31; i++) {
            saving.getData().add(new XYChart.Data(i, i*12*monthSlider.getValue()));
        }
  
        XYChart.Series interest = new XYChart.Series();
        
        lineChart.getData().add(saving);
        lineChart.getData().add(interest);
        
        //VBox
        VBox top = new VBox();
        top.getChildren().addAll(monthLayout, yearLayout);
        top.setSpacing(10);
        
        //Slider Update
        monthSlider.valueProperty().addListener((current, oldValue, newValue) -> {
            monthSliderValue.setText("" + newValue.intValue());
            saving.getData().clear();
            for (int i=0; i<31; i++) {
                saving.getData().add(new XYChart.Data(i, i*12*newValue.intValue()));
            }
            interest.getData().clear();
            for (int i=0; i<31; i++) {
                interest.getData().add(new XYChart.Data(i, interestAmount(i, newValue.intValue(), yearSlider.getValue())));
            }
        });
        
        yearSlider.valueProperty().addListener((current, oldValue, newValue) -> {
            yearSliderValue.setText("" + newValue);
            saving.getData().clear();
            for (int i=0; i<31; i++) {
                saving.getData().add(new XYChart.Data(i, i*12*(int)monthSlider.getValue()));
            }
            interest.getData().clear();
            for (int i=0; i<31; i++) {
                interest.getData().add(new XYChart.Data(i, interestAmount(i, (int)monthSlider.getValue(), (double)newValue)));
            }
        });
        
        //Layout
        BorderPane layout = new BorderPane();
        layout.setTop(top);
        layout.setCenter(lineChart);
        
        //Scene
        Scene view = new Scene(layout, 900, 600);
        stage.setScene(view);
        stage.show();
    }
    
    public double interestAmount(Integer index, Integer monthValue, Double interest) {
        ArrayList<Double> list = new ArrayList<>();
        double sum = 0;
        list.add(0.0);
        for (int i=1; i<31; i++) {
            sum += monthValue*12;
            list.add(sum*(1+interest/100));
            sum = sum*(1+interest/100);
        }
        return list.get(index);
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

}
