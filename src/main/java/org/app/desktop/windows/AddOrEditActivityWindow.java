package org.app.desktop.windows;
import org.app.desktop.form.ActivityForm;

import javax.swing.*;
import java.awt.*;

public class AddOrEditActivityWindow extends JFrame {
    public AddOrEditActivityWindow(){
        super("Une fenêtre");
        setBounds(0,0, 600, 450);
        /* OU :
        setLocation(); setSize()
         */

        /* Annule les fonction supérieure pour compacter la fenêtre
        pack();
         */

        // Centre une fenetre
        setLocationRelativeTo(null);

        Toolkit tk = Toolkit.getDefaultToolkit();
        /* Méthodes utiles : getScreenSize, getScreenResolution,
        getDefaultToolkit, beep, getImage,
        createImage, getSystemEventQueue
        */
        tk.beep();

        ActivityForm activityForm = new ActivityForm();
        JPanel panel = activityForm.getPanel1();

        Container cp = this.getContentPane();
        cp.add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame window = new AddOrEditActivityWindow();
    }
}


