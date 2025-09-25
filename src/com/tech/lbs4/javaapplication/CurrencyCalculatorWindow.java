/*
 * Created by JFormDesigner on Thu Sep 25 15:30:58 CEST 2025
 */

package com.tech.lbs4.javaapplication;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Lieke.SCHORS
 */
public class CurrencyCalculatorWindow extends JPanel {
    public CurrencyCalculatorWindow() {
        initComponents();
    }

    public JTextField getCurrencyToTextField() {
        return currencyToTextField;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Lieke Schors
        ResourceBundle bundle = ResourceBundle.getBundle("com.tech.lbs4.javaapplication.currencycalc");
        panel1 = new JPanel();
        amountFromLabel = new JLabel();
        currencyFromComboBox = new JCombobox(Currency.values());
        currencyFromTextField = new JTextField();
        amountToLabel = new JLabel();
        currencyToCombobox = new JCombobox(Currency.values());
        currencyToTextField = new JTextField();
        calcButton = new JButton();

        //======== panel1 ========
        {
            panel1.setMinimumSize(new Dimension(336, 258));
            panel1.setMaximumSize(new Dimension(1900, 1800));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
            . EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax
            . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
            12 ), java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans
            . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .
            getPropertyName () )) throw new RuntimeException( ); }} );
            panel1.setLayout(new FormLayout(
                "$ugap, 2*(default, $lcgap), default",
                "$ugap, 2*(default, $rgap), default"));

            //---- amountFromLabel ----
            amountFromLabel.setText(bundle.getString("CurrencyCalculatorWindow.amountFromLabel.text"));
            panel1.add(amountFromLabel, CC.xy(2, 2));
            panel1.add(currencyFromComboBox, CC.xy(4, 2));

            //---- currencyFromTextField ----
            currencyFromTextField.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(currencyFromTextField, CC.xy(6, 2));

            //---- amountToLabel ----
            amountToLabel.setText(bundle.getString("CurrencyCalculatorWindow.amountToLabel.text"));
            panel1.add(amountToLabel, CC.xy(2, 4));
            panel1.add(currencyToCombobox, CC.xy(4, 4));

            //---- currencyToTextField ----
            currencyToTextField.setEditable(false);
            currencyToTextField.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(currencyToTextField, CC.xy(6, 4));

            //---- calcButton ----
            calcButton.setText(bundle.getString("CurrencyCalculatorWindow.calcButton.text"));
            calcButton.setBackground(new Color(0xf19b2f));
            calcButton.setFocusTraversalPolicyProvider(true);
            calcButton.setFont(new Font("Inter", Font.BOLD, 13));
            panel1.add(calcButton, CC.xy(6, 6));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Lieke Schors
    private JPanel panel1;
    private JLabel amountFromLabel;
    private JComboBox<Currency> currencyFromComboBox;
    private JTextField currencyFromTextField;
    private JLabel amountToLabel;
    private JComboBox<Currency> currencyToCombobox;
    private JTextField currencyToTextField;
    private JButton calcButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
