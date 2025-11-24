package org.example.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.scene.text.Font;
import org.example.model.Currency;
import org.example.model.CurrencyModel;

public class CurrencyView {
    public TextField amountField;
    public TextField resultField;
    public ComboBox<Currency> fromComboBox;
    public ComboBox<Currency> toComboBox;
    public Button convertButton;

    public void start(Stage stage, CurrencyModel model) {
        // Labels
        Label amountLabel = new Label("Amount:");
        Label fromLabel = new Label("From Currency:");
        Label toLabel = new Label("To Currency:");
        Label resultLabel = new Label("Converted Amount:");

        // Fields
        amountField = new TextField();
        resultField = new TextField();
        resultField.setEditable(false);

        // Numeric input only
        amountField.textProperty().addListener((obs, oldValue, newValue) -> {
            if (!newValue.matches("\\d*(\\.\\d*)?")) {
                amountField.setText(oldValue);
            }
        });

        // ComboBoxes
        fromComboBox = new ComboBox<>();
        toComboBox = new ComboBox<>();
        fromComboBox.getItems().addAll(model.getCurrencies());
        toComboBox.getItems().addAll(model.getCurrencies());

        fromComboBox.setConverter(new StringConverter<>() {
            @Override
            public String toString(Currency currency) {
                return currency == null ? "" : currency.toString();
            }

            @Override
            public Currency fromString(String s) { return null; }
        });

        toComboBox.setConverter(new StringConverter<>() {
            @Override
            public String toString(Currency currency) {
                return currency == null ? "" : currency.toString();
            }

            @Override
            public Currency fromString(String s) { return null; }
        });

        convertButton = new Button("Convert");

        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(15);
        grid.setHgap(15);

        grid.add(amountLabel, 0, 0);
        grid.add(amountField, 1, 0);
        grid.add(fromLabel, 0, 1);
        grid.add(fromComboBox, 1, 1);
        grid.add(toLabel, 0, 2);
        grid.add(toComboBox, 1, 2);
        grid.add(convertButton, 0, 3);
        grid.add(resultLabel, 0, 4);
        grid.add(resultField, 1, 4);

        // Scene
        Scene scene = new Scene(grid, 450, 300);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Currency Converter");
        stage.show();
    }
}
