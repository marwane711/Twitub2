package main.java.com.ubo.tp.twitub.ihm;

import main.java.com.ubo.tp.twitub.datamodel.Twit;
import main.java.com.ubo.tp.twitub.observeurPattern.ObservableTwit;
import main.java.com.ubo.tp.twitub.observeurPattern.ObserveurTwit;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class VueAfficherTweet extends JPanel implements ObservableTwit {
	
	Set<ObserveurTwit> mObserveursTwit;

    public VueAfficherTweet(Set<Twit> twits) {
    	
    	this.mObserveursTwit = new HashSet<ObserveurTwit>();
    	
        this.setLayout(new GridLayout(twits.size() + 1, 1)); // +1 pour le champ texte et le bouton
        for (Twit twit : twits) {
            // Créer une bordure fine de couleur bleu foncé
            Border border = BorderFactory.createLineBorder(new Color(0, 0, 128), 1);
            // Créer une JPanel pour contenir chaque twit avec la bordure
            JPanel twitPanel = new JPanel(new BorderLayout());
            twitPanel.setPreferredSize(new Dimension(300, 50));
            twitPanel.setBorder(border);
            //Ajouter une case à gauche pour afficher le pseudo de l'utilisateur
            JLabel username = new JLabel(twit.getTwiter().getUserTag() + ": ");
            username.setFont(new Font("Arial", Font.BOLD, 20));
            twitPanel.add(username, BorderLayout.WEST);
            // Ajouter le texte du twit à un JLabel
            JLabel text = new JLabel(twit.getText());
            text.setFont(new Font("Arial", Font.PLAIN, 20));
            // Ajouter le JLabel au JPanel
            twitPanel.add(text, BorderLayout.CENTER);
            // Ajouter le JPanel à cette VueAfficherTweet
            this.add(twitPanel);
        }

        // Créer une JPanel pour contenir le champ texte et le bouton "Publier"
        JPanel nvTwitPanel = new JPanel(new BorderLayout());
        nvTwitPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Ajouter un peu d'espace en haut et en bas

        // Ajouter un champ texte pour saisir un nouveau twit
        JTextField champTexte = new JTextField();
        champTexte.setFont(new Font("Arial", Font.PLAIN, 18));
        champTexte.setPreferredSize(new Dimension(0, 0)); // Largeur minimale
        champTexte.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100)); // Hauteur maximale
        nvTwitPanel.add(champTexte, BorderLayout.CENTER);

        // Ajouter un bouton "Publier"
        JButton publierButton = new JButton("Publier");
        publierButton.setPreferredSize(new Dimension(70, 25)); // Dimensions personnalisées
        publierButton.setBorder(BorderFactory.createLineBorder(Color.black));
        publierButton.setMargin(new Insets(0, 0, 0, 0)); // Enlever l'espace entre le texte et le bord du bouton
        nvTwitPanel.add(publierButton, BorderLayout.EAST);
        publierButton.addActionListener(e -> notifyObserveurs(champTexte.getText()));

        this.add(nvTwitPanel);
    }

    @Override
	public void addObserveur(ObserveurTwit o) {
		this.mObserveursTwit.add(o);
	}

	@Override
	public void removeObserveur(ObserveurTwit o) {
		this.mObserveursTwit.remove(o);
	}

	@Override
	public void notifyObserveurs(String twitText) {
		for(ObserveurTwit o : this.mObserveursTwit) {
			o.newTwitSent(twitText);
		}
	}
}
