package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;

public class PartiesApplication extends Application {
    
    private HashMap<String, HashMap<Integer, Double>> values;
    
    public PartiesApplication() {
        this.values = voterFile("partiesdata.tsv");
    }

    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        values.keySet().stream().forEach(party -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(party);

            values.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });

            lineChart.getData().add(data);
        });

        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }
    
    public HashMap<String, HashMap<Integer, Double>> voterFile(String filename) {
        HashMap<String, HashMap<Integer, Double>> values = new HashMap<>();
        ArrayList<Integer> year = new ArrayList<>();
        
        try (Scanner filescan = new Scanner(Paths.get(filename))) {
            String row = filescan.nextLine();
            String[] parts = row.split("\t");
            for (int i=1; i<parts.length; i++) {
                year.add(Integer.valueOf(parts[i]));
            }
            while (filescan.hasNextLine()) {
                HashMap<Integer, Double> pair = new HashMap<>();
                String data = filescan.nextLine();
                String[] datapts = data.split("\t");
                for (int i=1; i<datapts.length; i++) {
                    if (!datapts[i].equals("-")) {
                        pair.put(year.get(i-1), Double.valueOf(datapts[i]));
                    }
                }
                values.put(datapts[0], pair);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return values;
        
    }
    
    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

}
