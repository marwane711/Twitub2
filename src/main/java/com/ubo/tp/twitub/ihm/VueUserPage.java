package main.java.com.ubo.tp.twitub.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.java.com.ubo.tp.twitub.datamodel.User;
import main.java.com.ubo.tp.twitub.observeurPattern.ObservableInscriptionConnexion;
import main.java.com.ubo.tp.twitub.observeurPattern.ObservableTwit;
import main.java.com.ubo.tp.twitub.observeurPattern.ObserveurInscription;
import main.java.com.ubo.tp.twitub.observeurPattern.ObserveurTwit;

public class VueUserPage extends JPanel implements ObservableTwit, ObservableInscriptionConnexion {
	
    User user;
    Set<ObserveurTwit> mObserveursTwit;
    Set<ObserveurInscription> mObserveursDeco;
    
    public VueUserPage(User user) {
        this.user = user;
        this.mObserveursTwit = new HashSet<ObserveurTwit>(); 
        this.mObserveursDeco = new HashSet<ObserveurInscription>(); 
        String name = this.user.getName();
        String username = this.user.getUserTag();

        // Créer les étiquettes pour afficher les messages
        JLabel welcomeLabel = new JLabel("Bienvenue");
        JLabel nameLabel = new JLabel("Nom : " + name);
        JLabel usernameLabel = new JLabel("Pseudo : " + username);

        // Créer les boutons
        JButton twitsButton = new JButton("Afficher les Twits");
        twitsButton.addActionListener(e -> notifyObserveurs(null));
        
        JButton logoutButton = new JButton("Se déconnecter");
        logoutButton.addActionListener(e -> notifyObserveurDeconnecte());
        logoutButton.setBackground(Color.RED);
        logoutButton.setForeground(Color.WHITE);

        // Définir la mise en page en boîte avec l'axe Y
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Centrer les composants horizontalement
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        twitsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Ajouter des marges et des espaces entre les composants
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(welcomeLabel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(nameLabel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(usernameLabel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(twitsButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(logoutButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
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
		System.out.println("notify");
		for(ObserveurTwit o : this.mObserveursTwit) {
			o.myTwits();
		}
	}

	@Override
	public void addObservateur(ObserveurInscription o) {
		this.mObserveursDeco.add(o);
	}
	
	@Override
	public void notifyObserveurDeconnecte() {
		for(ObserveurInscription o : this.mObserveursDeco) {
			o.deconnecte();
		} 
	}

	@Override
	public void removeObservateur(ObserveurInscription o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservateurInscription() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservateurConnexion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservateurConnecte() {
		// TODO Auto-generated method stub
		
	}

}