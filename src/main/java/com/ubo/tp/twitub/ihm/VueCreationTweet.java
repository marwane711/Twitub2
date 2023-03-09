package main.java.com.ubo.tp.twitub.ihm;

import main.java.com.ubo.tp.twitub.datamodel.IDatabase;
import main.java.com.ubo.tp.twitub.datamodel.User;

import javax.swing.*;
import java.awt.*;

public class VueCreationTweet {

    protected JPanel panel;
    protected User user;

    protected IDatabase mDatabase;
    protected JButton button;

    public VueCreationTweet(User user, IDatabase mDatabase) {
        this.user = user;
        this.mDatabase = mDatabase;
        panel = new JPanel();

        button = new JButton("Créer nouveau tweet");
        panel.add(button);
        button.addActionListener(e -> fabriqueTweet(panel));

    }

    public  void ajoutTweetDataBase(String text) {
        System.out.println("Ajout du tweet : " + text);






    }

    public void fabriqueTweet(JPanel panel) {
        changeVisibilityButton();
        JTextArea textArea = new JTextArea();
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLUE)); // Ajouter une bordure bleue

        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        JButton addTweetButton = new JButton("Ajouter un tweet");
        addTweetButton.addActionListener(e -> ajoutTweetDataBase(textArea.getText()));

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; // Position en colonne
        c.gridy = 0; // Position en ligne
        c.gridwidth = 1; // Nombre de colonnes à occuper
        c.gridheight = 1; // Nombre de lignes à occuper
        c.weightx = 1.0; // Poids horizontal (pour le centrage)
        c.weighty = 4; // Poids vertical (pour le centrage)
        c.anchor = GridBagConstraints.NORTHEAST; // Alignement en haut à droite
        c.fill = GridBagConstraints.BOTH; // Remplir l'espace disponible dans les deux directions
        c.insets = new Insets(5, 5, 5, 5); // Marges intérieures

        panel.add(textArea, c);

        c.gridx = 0; // Position en colonne
        c.gridy = 1; // Position en ligne
        c.gridwidth = 1; // Nombre de colonnes à occuper
        c.gridheight = 1; // Nombre de lignes à occuper
        c.weightx = 1.0; // Poids horizontal (pour le centrage)
        c.weighty = 1; // Poids vertical (pour le centrage)
        c.anchor = GridBagConstraints.SOUTHEAST; // Alignement en haut à droite
        c.fill = GridBagConstraints.BOTH; // Remplir l'espace disponible dans les deux directions
        c.insets = new Insets(5, 5, 5, 5); // Marges intérieures

        panel.add(addTweetButton, c);
        panel.revalidate();
    }


    public void changeVisibilityButton() {
        button.setVisible(!button.isVisible());

    }


    public JPanel getPanel() {
        return panel;
    }


}
