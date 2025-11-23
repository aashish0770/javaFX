package org.example.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Dictionary {
    private final Map<String, String> entries;

    public Dictionary() {
        entries = new HashMap<>();
    }

    // Add a word + its meaning
    public void addWord(String word, String meaning) {
        if (word == null || word.isBlank()) {
            throw new IllegalArgumentException("Word cannot be empty");
        }
        entries.put(word.toLowerCase().trim(), meaning);
    }

    // Get meaning, returns Optional to avoid forcing exceptions on caller
    public Optional<String> getMeaning(String word) {
        if (word == null || word.isBlank()) {
            throw new IllegalArgumentException("Please enter a word.");
        }
        return Optional.ofNullable(entries.get(word.toLowerCase().trim()));
    }
}
