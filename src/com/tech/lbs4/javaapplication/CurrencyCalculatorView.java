package com.tech.lbs4.javaapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyCalculatorView implements ActionListener {

    private JFrame frame;
    private Currency currencyFrom;
    private Currency currencyTo;
    private JLabel currencyFromLabel;
    private double amountFrom;
    private JTextField amountFromTextField;
    private JComboBox<Currency> currencyFromCombobox;
    private JLabel currencyToLabel;
    private JComboBox<Currency> currencyToCombobox;
    private JTextField amountToTextField;

    private JButton calcButton;


    public void generateFrame() {
        frame = new JFrame("Währungsrechner");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3, 5, 5));

        currencyFromLabel = new JLabel("Betrag in: ");
        currencyFromLabel.putClientProperty("JComponent.sizeVariant", "mini");
        currencyFromCombobox = new JComboBox<>(Currency.values());
        currencyFromCombobox.setSelectedIndex(0);
        amountFromTextField = new JTextField();
        amountFromTextField.setHorizontalAlignment(JTextField.RIGHT);

        currencyToLabel = new JLabel("Betrag in: ");
        currencyToCombobox = new JComboBox<>(Currency.values());
        currencyToCombobox.setSelectedIndex(1);

        amountToTextField = new JTextField();
        amountToTextField.setEditable(false);
        amountToTextField.setFont(new Font("Arial", Font.BOLD, 12));
        amountToTextField.setBorder(null);
        amountToTextField.setHorizontalAlignment(JTextField.RIGHT);


        calcButton = new JButton("Berechnen");
        calcButton.addActionListener(this);
        calcButton.setBackground(Color.orange);

        // First Row
        frame.add(currencyFromLabel);
        frame.add(currencyFromCombobox);
        frame.add(amountFromTextField);

        // Second Row
        frame.add(currencyToLabel);
        frame.add(currencyToCombobox);
        frame.add(amountToTextField);

        // Third Row
        JTextField fillComp1 = new JTextField();
        fillComp1.setBorder(null);
        fillComp1.setEditable(false);
        frame.add(fillComp1);

        JTextField fillComp2 = new JTextField();
        fillComp2.setBorder(null);
        fillComp2.setEditable(false);
        frame.add(fillComp2);
        frame.add(calcButton, -1);

        SwingUtilities.updateComponentTreeUI(frame);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currencyFrom = (Currency) currencyFromCombobox.getSelectedItem();
        currencyTo = (Currency) currencyToCombobox.getSelectedItem();
        setAmountFromDoubleValue();

        String waehrungNichtUnterstuetztMessage = "Diese Währung wird (noch) nicht unterstützt.";
        double calculatedResult;
        if (currencyFrom != null && currencyTo != null) {
            switch (currencyFrom) {
                case EURO:
                    switch (currencyTo) {
                        case EURO -> calculatedResult = amountFrom;
                        case USD -> calculatedResult = amountFrom * Currency.EURO.getErUsd();
                        case STERLING -> calculatedResult = amountFrom * Currency.EURO.getErSterling();
                        case AUD -> calculatedResult = amountFrom * Currency.EURO.getErAud();
                        default -> {
                            JOptionPane.showMessageDialog(frame, waehrungNichtUnterstuetztMessage, "Info", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                    }
                    break;
                case USD:
                    switch (currencyTo) {
                        case EURO -> calculatedResult = amountFrom * Currency.USD.getErEuro();
                        case USD -> calculatedResult = amountFrom;
                        case STERLING -> calculatedResult = amountFrom * Currency.USD.getErSterling();
                        case AUD -> calculatedResult = amountFrom * Currency.USD.getErAud();
                        default -> {
                            JOptionPane.showMessageDialog(frame, waehrungNichtUnterstuetztMessage, "Info", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                    }
                    break;
                case STERLING:
                    switch (currencyTo) {
                        case EURO -> calculatedResult = amountFrom * Currency.STERLING.getErEuro();
                        case USD -> calculatedResult = amountFrom * Currency.STERLING.getErUsd();
                        case STERLING -> calculatedResult = amountFrom;
                        case AUD -> calculatedResult = amountFrom * Currency.STERLING.getErAud();
                        default -> {
                            JOptionPane.showMessageDialog(frame, waehrungNichtUnterstuetztMessage, "Info", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                    }
                    break;
                case AUD:
                    switch (currencyTo) {
                        case EURO -> calculatedResult = amountFrom * Currency.AUD.getErEuro();
                        case USD -> calculatedResult = amountFrom * Currency.AUD.getErUsd();
                        case STERLING -> calculatedResult = amountFrom * Currency.AUD.getErSterling();
                        case AUD -> calculatedResult = amountFrom;
                        default -> {
                            JOptionPane.showMessageDialog(frame, waehrungNichtUnterstuetztMessage, "Info", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, waehrungNichtUnterstuetztMessage, "Info", JOptionPane.WARNING_MESSAGE);
                    return;
            }
        } else {
            JOptionPane.showMessageDialog(frame,
                    "Bitte wählen Sie beide Währungen aus.", "Hinweis",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        amountToTextField.setText(String.format("%.3f", calculatedResult) + " " + currencyTo);
    }

    /**
     * This method tries to cast the user input into a double-type.
     * Unless it is a valid double, the user is asked to change the input.
     */
    private void setAmountFromDoubleValue() {
        boolean allowedValued = false;

        do {
            try {
                amountFrom = Double.parseDouble(amountFromTextField.getText());
                allowedValued = true;
            } catch (NumberFormatException e) {
                amountFrom = 0;
                String errorMessage = "Bitte geben Sie eine Zahl ein und verwenden Sie als . anstatt , für Dezimalwerte.";
                JOptionPane.showMessageDialog(frame, errorMessage, "Fehler", JOptionPane.ERROR_MESSAGE);
                amountFromTextField.setText("Fehler");
            }
        } while (!allowedValued);
    }
}
