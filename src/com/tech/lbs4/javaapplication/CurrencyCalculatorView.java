/*
 * Created by JFormDesigner on Fri Sep 26 08:01:35 CEST 2025
 */

package com.tech.lbs4.javaapplication;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import jdk.javadoc.doclet.Taglet;

/**
 * @author Lieke.SCHORS
 */
public class CurrencyCalculatorView implements ActionListener {

    private Currency currencyFrom;
    private double amountFrom;

    private Currency currencyTo;



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Lieke Schors
        ResourceBundle bundle = ResourceBundle.getBundle("com.tech.lbs4.javaapplication.currencycalc");
        mainFrame = new JFrame();
        mainFrame.getContentPane().setBackground(new Color(0x2eb2f6));
        amountFromLabel = new JLabel();
        currencyFromComboBox = new JComboBox<>(Currency.values());
        amountFromTextField = new JTextField();
        amountToLabel = new JLabel();
        currencyToCombobox = new JComboBox<>(Currency.values());
        currencyToTextField = new JTextField();
        calcButton = new JButton();
        desktopPane1 = new JDesktopPane();

        //======== mainFrame ========
        {
            mainFrame.setMinimumSize(new Dimension(336, 258));
            mainFrame.setMaximumSize(new Dimension(1900, 1800));
            mainFrame.setName("W\u00e4hrungsrechner");
            mainFrame.setTitle("W\u00e4hrungsrechner");
            mainFrame.setBackground(new Color(0x2eb2f6));
            mainFrame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            mainFrame.setPreferredSize(new Dimension(500, 300));
            mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            mainFrame.setFocusTraversalPolicyProvider(true);
            mainFrame.setFont(new Font("Javanese Text", Font.PLAIN, 16));
            mainFrame.setForeground(Color.black);
            var mainFrameContentPane = mainFrame.getContentPane();
            mainFrameContentPane.setLayout(new FormLayout(
                "50dlu, 2*(default, $lcgap), default",
                "50dlu, 2*(default, $rgap), default, $lgap, default"));
            mainFrame.getRootPane().setDefaultButton(calcButton);

            //---- amountFromLabel ----
            amountFromLabel.setText(bundle.getString("CurrencyCalculatorWindow.amountFromLabel.text"));
            mainFrameContentPane.add(amountFromLabel, CC.xy(2, 2));
            mainFrameContentPane.add(currencyFromComboBox, CC.xy(4, 2));

            //---- amountFromTextField ----
            amountFromTextField.setHorizontalAlignment(SwingConstants.RIGHT);
            mainFrameContentPane.add(amountFromTextField, CC.xy(6, 2));

            //---- amountToLabel ----
            amountToLabel.setText(bundle.getString("CurrencyCalculatorWindow.amountToLabel.text"));
            mainFrameContentPane.add(amountToLabel, CC.xy(2, 4));
            mainFrameContentPane.add(currencyToCombobox, CC.xy(4, 4));

            //---- currencyToTextField ----
            currencyToTextField.setEditable(false);
            currencyToTextField.setHorizontalAlignment(SwingConstants.RIGHT);
            mainFrameContentPane.add(currencyToTextField, CC.xy(6, 4));

            //---- calcButton ----
            calcButton.setText(bundle.getString("CurrencyCalculatorWindow.calcButton.text"));
            calcButton.setBackground(new Color(0xf19b2f));
            calcButton.setFocusTraversalPolicyProvider(true);
            calcButton.setFont(new Font("Tahoma", Font.BOLD, 20));
            calcButton.addActionListener(this);
            calcButton.setMnemonic(KeyEvent.VK_ENTER);
            mainFrameContentPane.add(calcButton, CC.xy(6, 6));
            mainFrameContentPane.add(desktopPane1, CC.xy(1, 8));
            mainFrame.pack();
            mainFrame.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Lieke Schors
    private JFrame mainFrame;
    private JLabel amountFromLabel;
    private JComboBox<Currency> currencyFromComboBox;
    private JTextField amountFromTextField;
    private JLabel amountToLabel;
    private JComboBox<Currency> currencyToCombobox;
    private JTextField currencyToTextField;
    private JButton calcButton;
    private JDesktopPane desktopPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public void getMainFrame() {
        initComponents();
        currencyToCombobox.setSelectedIndex(Currency.USD.ordinal());
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currencyFrom = (Currency) currencyFromComboBox.getSelectedItem();
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
                            JOptionPane.showMessageDialog(mainFrame, waehrungNichtUnterstuetztMessage, "Info", JOptionPane.WARNING_MESSAGE);
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
                            JOptionPane.showMessageDialog(mainFrame, waehrungNichtUnterstuetztMessage, "Info", JOptionPane.WARNING_MESSAGE);
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
                            JOptionPane.showMessageDialog(mainFrame, waehrungNichtUnterstuetztMessage, "Info", JOptionPane.WARNING_MESSAGE);
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
                            JOptionPane.showMessageDialog(mainFrame, waehrungNichtUnterstuetztMessage, "Info", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(mainFrame, waehrungNichtUnterstuetztMessage, "Info", JOptionPane.WARNING_MESSAGE);
                    return;
            }
        } else {
            JOptionPane.showMessageDialog(mainFrame,
                    "Bitte wählen Sie beide Währungen aus.", "Hinweis",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        currencyToTextField.setText(String.format("%.3f", calculatedResult) + " " + currencyTo);
    }

    /**
     * This method tries to cast the user input into a double-type.
     * Unless it is a valid double, the user is asked to change the input.
     */
    private void setAmountFromDoubleValue() {
            try {
                amountFrom = Double.parseDouble(amountFromTextField.getText().replace(',', '.'));
            } catch (NumberFormatException e) {
                amountFrom = 0;
                String errorMessage = "Bitte geben Sie eine Zahl ein.";
                JOptionPane.showMessageDialog(mainFrame, errorMessage, "Fehler", JOptionPane.ERROR_MESSAGE);
                amountFromTextField.setText("");
                amountFromTextField.requestFocusInWindow();
            }
    }
}
