package ru.unn.agile.calc.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StringCalcApp extends Application {

    private static final int APP_HEIGHT = 350;
    private static final int APP_WIDTH = 600;

    @Override
    public void start(final Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("StringCalculator.fxml"));

        primaryStage.setTitle("String Calculator");
        primaryStage.setHeight(APP_HEIGHT);
        primaryStage.setWidth(APP_WIDTH);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}
