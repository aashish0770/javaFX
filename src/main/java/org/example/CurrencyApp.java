package org.example;
import javafx.application.Application;
import javafx.stage.Stage;
import org.example.controller.CurrencyController;
import org.example.model.CurrencyModel;
import org.example.view.CurrencyView;

public class CurrencyApp extends Application {
    @Override
    public void start(Stage stage) {
        CurrencyModel model = new CurrencyModel();
        CurrencyView view = new CurrencyView();
        new CurrencyController(model, view);

        view.start(stage, model);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

