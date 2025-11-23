package org.example.controller;

import org.example.model.Dictionary;

public class DictionaryController {
    private final Dictionary model;

    public DictionaryController() {
        model = new Dictionary();
        // Hard-coded entries for testing (you can load from file/db later)
        model.addWord("apple", "A round fruit of a tree of the rose family.");
        model.addWord("java", "A high-level programming language used to create applications.");
        model.addWord("dictionary", "A reference book or electronic resource containing words and meanings.");
        model.addWord("computer", "An electronic device used for processing data.");
    }

    /**
     * Search for a word. Returns the meaning or a friendly message if not found / invalid.
     * Controller does not depend on JavaFX classes; it only accepts Strings.
     */
    public String search(String word) {
        try {
            var meaningOpt = model.getMeaning(word);
            return meaningOpt.orElse("Word not found: " + word);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        } catch (Exception ex) {
            // Unexpected errors
            return "An error occurred: " + ex.getMessage();
        }
    }

    // Optional: an API to add words at runtime (keeps separation from view)
    public String addWord(String word, String meaning) {
        try {
            model.addWord(word, meaning);
            return "Added: " + word;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
