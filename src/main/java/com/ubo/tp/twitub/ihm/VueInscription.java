package main.java.com.ubo.tp.twitub.ihm;

import main.java.com.ubo.tp.twitub.controler.CtrlInscription;

import javax.swing.*;

public class VueInscription extends JFrame {
    private JTextField Nom;
    private JTextField Tag;

    private JTextField Avatar;

    private JButton button;
    private JTextArea textArea;



    public VueInscription(CtrlInscription CtrlmonInscription) {
        super("Inscription");

        System.out.println("test");


        JTextField nameField = new JTextField();
        JTextField tagField = new JTextField();
        JTextField mdpField = new JTextField();

        Object[] fields = {
                "Nom:", nameField,
                "Tag", tagField,
                "mot de passe", mdpField
        };


        int result = JOptionPane.showConfirmDialog(null, fields, "Formulaire", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String tag = tagField.getText();
            String mdp = mdpField.getText();

            if (name.isEmpty() || tag.isEmpty() || mdp.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                boolean estcree = CtrlmonInscription.createUsers(tag, mdp, name);

                if (estcree) {
                    JOptionPane.showMessageDialog(null, "Inscription réussie", "Succès", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Inscription échouée", "Erreur", JOptionPane.ERROR_MESSAGE);
                }

            }

            // do something with the name and age values
        } else {
            System.out.println("Cancelled");
        }
    }
}
