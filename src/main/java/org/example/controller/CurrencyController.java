package org.example.controller;

import org.example.model.Currency;
import org.example.model.CurrencyModel;
import org.example.view.CurrencyView;

public class CurrencyController {
    private CurrencyModel model;
    private CurrencyView view;

    public CurrencyController(CurrencyModel model, CurrencyView view) {
        this.model = model;
        this.view = view;

        view.convertButton.setOnAction(e -> convertCurrency());
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(view.amountField.getText());
            Currency from = view.fromComboBox.getValue();
            Currency to = view.toComboBox.getValue();

            if (from == null || to == null) {
                view.resultField.setText("Select both currencies");
                return;
            }

            double result = model.convert(amount, from, to);
            view.resultField.setText(String.format("%.2f", result));
        } catch (NumberFormatException e) {
            view.resultField.setText("Invalid amount");
        }
    }
}
