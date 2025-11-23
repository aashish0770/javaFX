package org.example.view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.example.controller.DictionaryController;

/**
 * A reusable JavaFX view component (not Application). MainApp will create and show it.
 */
public class DictionaryView extends VBox {
    private final DictionaryController controller;

    private final TextField wordField;
    private final Button searchButton;
    private final TextArea meaningArea;
    private final Button addButton;

    public DictionaryView(DictionaryController controller) {
        this.controller = controller;

        // UI Controls
        Label promptLabel = new Label("Enter word:");
        wordField = new TextField();
        wordField.setPromptText("Type a word (e.g., java)");

        searchButton = new Button("Search");
        addButton = new Button("Add sample");
        meaningArea = new TextArea();
        meaningArea.setEditable(false);
        meaningArea.setWrapText(true);
        meaningArea.setPrefRowCount(6);

        // Layout
        FlowPane inputPane = new FlowPane();
        inputPane.setHgap(10);
        inputPane.setVgap(10);
        inputPane.setPadding(new Insets(10));
        inputPane.getChildren().addAll(promptLabel, wordField, searchButton, addButton);

        setPadding(new Insets(10));
        setSpacing(10);
        getChildren().addAll(inputPane, meaningArea);
        VBox.setVgrow(meaningArea, Priority.ALWAYS);

        // Event handling (view only uses controller via Strings)
        searchButton.setOnAction(e -> onSearch());
        wordField.setOnAction(e -> onSearch()); // Enter key triggers search

        // Example: addButton adds the currently typed word as a sample (for testing)
        addButton.setOnAction(e -> {
            String w = wordField.getText().trim();
            if (w.isEmpty()) {
                meaningArea.setText("Enter a word to add it as a sample (will add a placeholder meaning).");
            } else {
                String msg = controller.addWord(w, "Placeholder meaning for " + w);
                meaningArea.setText(msg);
            }
        });
    }

    private void onSearch() {
        String word = wordField.getText().trim();
        if (word.isEmpty()) {
            meaningArea.setText("Please enter a word to search.");
            return;
        }
        String result = controller.search(word);
        meaningArea.setText(result);
    }
}
