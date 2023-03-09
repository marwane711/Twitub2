package main.java.com.ubo.tp.twitub.ihm;

import main.java.com.ubo.tp.twitub.controler.CtrlConnexion;

import javax.swing.*;
import java.awt.*;

public class VueConnexion extends JFrame  {

   // protected Set<IObserveurConnexVerif> listObservers = new HashSet<IObserveurConnexVerif>();

    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton loginButton;

    CtrlConnexion ctrlConnexion;

    public VueConnexion (CtrlConnexion ctrlConnexion) {
        super("Connexion");
        this.ctrlConnexion = ctrlConnexion;

        this.setSize(300, 150);
        // Crée les champs de texte et le bouton de connexion
        this.loginField = new JTextField(20);
        this.passwordField = new JPasswordField(20);
        this.loginButton = new JButton("Connexion");

        // Crée un panneau pour les champs de texte et le bouton
        JPanel loginPanel = new JPanel();
        connexionPage(loginPanel);
        this.setVisible(true);

    }

    public void connexionPage(JPanel loginPanel) {

        loginPanel.setLayout(new GridLayout(3, 1, 5, 5));
        loginPanel.add(new JLabel("Identifiant:"));
        loginPanel.add(loginField);
        loginPanel.add(new JLabel("Mot de passe:"));
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        // Ajoute le panneau au contenu de la fenêtre
        setContentPane(loginPanel);
        // Configure la taille et l'emplacement de la fenêtre

        this.setLocationRelativeTo(null);

        loginButton.addActionListener(e -> maConnexion());

    }

    private void maConnexion() {
        if (loginField.getText().length() > 0 && passwordField.getPassword().length > 0) {
            if (this.ctrlConnexion.checkConnexion(loginField.getText(), passwordField.getText())== null) {
                JOptionPane.showMessageDialog(this, "Identifiant ou mot de passe incorrect", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this, "Identifiants correct", "Connecte", JOptionPane.OK_OPTION);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}