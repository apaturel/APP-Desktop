package org.app.desktop.form;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class ActivityForm {
    private JPanel panel1;
    private JTextField activityName;
    private JSpinner durationSpinner;

    private JSlider rpeSlider;
    private JButton backButton;
    private JButton validateButton;
    private JSpinner daySpinner;
    private JSpinner monthSpinner;
    private JSpinner yearSpinner;
    private JLabel rpeValue;

    Calendar calendar = Calendar.getInstance();

    int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
    int currentMonth = calendar.get(Calendar.MONTH) + 1;
    int currentYear = calendar.get(Calendar.YEAR);

    public ActivityForm() {

        durationSpinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
        daySpinner.setModel(new SpinnerNumberModel(currentDay, 1, 31, 1));
        monthSpinner.setModel(new SpinnerNumberModel(currentMonth, 1, 12, 1));
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(monthSpinner, "00");
        monthSpinner.setEditor(editor);
        yearSpinner.setModel(new SpinnerNumberModel(currentYear, 1900, currentYear, 1));
        yearSpinner.setEditor(new JSpinner.NumberEditor(yearSpinner, "#"));
        adjustDaySpinner();
        rpeSlider.setMinimum(0);
        rpeSlider.setMaximum(10);
        rpeSlider.setValue(0);
        rpeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int rpe = rpeSlider.getValue();
                rpeValue.setText(String.valueOf(rpe));
            }
        });

        monthSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                adjustDaySpinner();
            }
        });

        yearSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                adjustDaySpinner();
            }
        });

        // Désactivez le bouton de validation initialement
        validateButton.setEnabled(false);

        // Ajoutez un DocumentListener à nameTextField
        activityName.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                check();
            }
            public void removeUpdate(DocumentEvent e) {
                check();
            }
            public void insertUpdate(DocumentEvent e) {
                check();
            }

            public void check() {
                // Vérifiez si tous les champs sont remplis
                if (activityName.getText().trim().isEmpty()) {
                    // Si nameTextField est vide, désactivez le bouton de validation
                    validateButton.setEnabled(false);
                } else {
                    // Sinon, activez le bouton de validation
                    validateButton.setEnabled(true);
                }
            }
        });

        // Ajoutez un ActionListener à nextButton
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérez les informations de l'interface utilisateur
                String name = activityName.getText();
                int duration = (Integer) durationSpinner.getValue();
                int rpe = rpeSlider.getValue();
                int day = (Integer) daySpinner.getValue();
                int month = (Integer) monthSpinner.getValue();
                int year = (Integer) yearSpinner.getValue();

                // Affichez les informations dans la console
                System.out.println("Nom : " + name);
                System.out.println("Durée : " + duration);
                System.out.println("RPE : " + rpe);
                System.out.println("Date : " + day + "/" + month + "/" + year);
            }
        });

    }

    private void adjustDaySpinner() {
        int year = (Integer) yearSpinner.getValue();
        int month = (Integer) monthSpinner.getValue();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        daySpinner.setModel(new SpinnerNumberModel(currentDay, 1, maxDay, 1));
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
