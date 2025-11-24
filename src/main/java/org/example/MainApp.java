package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.controller.DictionaryController;
import org.example.view.DictionaryView;

/**
 * Main JavaFX Application launcher. This is the class referenced as <mainClass> in pom.xml.
 */
public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        DictionaryController controller = new DictionaryController();
        DictionaryView view = new DictionaryView(controller);

        Scene scene = new Scene(view, 520, 300);
        stage.setTitle("Virtual Dictionary (MVC)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}