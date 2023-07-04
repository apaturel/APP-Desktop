package org.app.desktop.windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel consultationPanel;

    public MenuWindow() {
        // Initialisation de la fenêtre
        frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Initialisation du CardLayout
        cardLayout = new CardLayout();
        consultationPanel = new JPanel(cardLayout);

        // Initialisation des panneaux
        JPanel mainMenuPanel = new JPanel(new BorderLayout());
        JPanel activityListPanel = new JPanel();

        // Ajouter des composants à chaque panneau
        JButton profileButton = new JButton("Profil");
        JButton consultationButton = new JButton("Consultation");

        JPanel topMenuPanel = new JPanel();
        topMenuPanel.add(profileButton);
        topMenuPanel.add(consultationButton);

        mainMenuPanel.add(topMenuPanel, BorderLayout.NORTH);
        mainMenuPanel.add(consultationPanel, BorderLayout.CENTER);

        activityListPanel.add(new JLabel("Activity List"));
        JButton backButton = new JButton("Retour");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(consultationPanel, "Empty");
            }
        });
        activityListPanel.add(backButton);

        JPanel emptyPanel = new JPanel();
        consultationPanel.add(emptyPanel, "Empty");
        consultationPanel.add(activityListPanel, "ActivityList");

        consultationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(consultationPanel, "ActivityList");
            }
        });

        // Ajouter le conteneur de cartes au cadre
        frame.add(mainMenuPanel);

        // rendre la fenêtre visible
        frame.setVisible(true);
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        MenuWindow menuWindow = new MenuWindow();
        menuWindow.show();
    }
}
