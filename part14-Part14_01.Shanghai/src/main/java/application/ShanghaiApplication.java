package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class ShanghaiApplication extends Application {

    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis(2007, 2017, 1);
        NumberAxis yAxis = new NumberAxis(50, 80, 1);

        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");

        XYChart.Series rkgData = new XYChart.Series();
        rkgData.setName("Rank");
        rkgData.getData().add(new XYChart.Data(2007, 73));
        rkgData.getData().add(new XYChart.Data(2008, 68));
        rkgData.getData().add(new XYChart.Data(2009, 72));
        rkgData.getData().add(new XYChart.Data(2010, 72));
        rkgData.getData().add(new XYChart.Data(2011, 74));
        rkgData.getData().add(new XYChart.Data(2012, 73));
        rkgData.getData().add(new XYChart.Data(2013, 76));
        rkgData.getData().add(new XYChart.Data(2014, 73));
        rkgData.getData().add(new XYChart.Data(2015, 67));
        rkgData.getData().add(new XYChart.Data(2016, 56));
        rkgData.getData().add(new XYChart.Data(2017, 56));

        lineChart.getData().add(rkgData);

        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

}
