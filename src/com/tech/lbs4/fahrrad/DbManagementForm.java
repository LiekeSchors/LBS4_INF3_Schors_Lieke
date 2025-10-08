/*
 * Created by JFormDesigner on Wed Oct 08 08:59:42 CEST 2025
 */

package com.tech.lbs4.fahrrad;

import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Lieke.SCHORS
 */
public class DbManagementForm extends JPanel {
    public DbManagementForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Lieke Schors
        tabelleHinzufügenLabel = new JLabel();

        //======== this ========
        setFont(new Font("Tahoma", Font.BOLD, 14));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
        ( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing. border
        . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
        propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );
        setLayout(new FormLayout(
            "4*(default:grow)",
            "fill:default:grow, 3*(default:grow)"));

        //---- tabelleHinzufügenLabel ----
        tabelleHinzufügenLabel.setText("Tabelle hinzuf\u00fcgen");
        add(tabelleHinzufügenLabel, CC.xy(1, 1));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Lieke Schors
    private JLabel tabelleHinzufügenLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
