package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class App extends Application {

    private XYChart.Series<Number, Number> series = new XYChart.Series<>();
    private int timeIndex = 0;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Dow Jones Stock Prices");

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time (ticks)");
        yAxis.setLabel("Price");

        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("DJI Live Stock Price");
        series.setName("Dow Jones");
        lineChart.getData().add(series);

        Scene scene = new Scene(lineChart, 800, 600);
        stage.setScene(scene);
        stage.show();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Stock dowJones = YahooFinance.get("^DJI");
                    BigDecimal price = dowJones.getQuote().getPrice();
                    javafx.application.Platform.runLater(() -> {
                        series.getData().add(new XYChart.Data<>(timeIndex++, price.doubleValue()));
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 5000);
    }

    public static void main(String[] args) {
        launch(args);
    }
}