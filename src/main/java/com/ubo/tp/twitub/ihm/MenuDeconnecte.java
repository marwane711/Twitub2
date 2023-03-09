package main.java.com.ubo.tp.twitub.ihm;

import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


import main.java.com.ubo.tp.twitub.observeurPattern.ObservableInscriptionConnexion;
import main.java.com.ubo.tp.twitub.observeurPattern.ObserveurInscription;
import main.java.com.ubo.tp.twitub.observeurPattern.ObserveurTwit;

public class MenuDeconnecte extends JMenuBar implements ObservableInscriptionConnexion{

	protected Set<ObserveurInscription> mObserveurs = new HashSet<ObserveurInscription>();
	
	public MenuDeconnecte() {
        JMenu menu = new JMenu("Fichier");
        this.add(menu);
        JMenuItem menuItem = new JMenuItem("Quitter");
        menu.add(menuItem);
        //item quit app
        menuItem.addActionListener(e -> System.exit(0));
        //add icone to menu
        ImageIcon icon = new ImageIcon("src/main/resources/images/exitIcon_20.png");
        menuItem.setIcon(icon);

        JMenu aPropos = new JMenu("Menu");
        this.add(aPropos);
        //open dialogbox about app
        JMenuItem about = new JMenuItem("A propos");
        aPropos.add(about);
        about.addActionListener(e -> about());

        JMenuItem inscription = new JMenuItem("Inscription");
        aPropos.add(inscription);
        inscription.addActionListener(e -> notifyObservateurInscription());
        JMenuItem connexion = new JMenuItem("Connexion");
        aPropos.add(connexion);
        connexion.addActionListener(e -> notifyObservateurConnexion());

	}
	
	//add dialogbox about app
    public void about() {
        JLabel label = new JLabel("<html><div style='text-align: center;'>UBO M2-TIIL<br/>Département infromatique<br/></div></html>");

        ImageIcon icon = new ImageIcon("src/main/resources/images/logo_50.jpg");

        JOptionPane optionPane = new JOptionPane();
        optionPane.showMessageDialog(null, label, "A propos", JOptionPane.INFORMATION_MESSAGE, icon);
    }
    
    @Override
    public void addObservateur(ObserveurInscription o) {
    mObserveurs.add(o);

    }

    @Override
    public void removeObservateur(ObserveurInscription o) {
    mObserveurs.remove(o);

    }

    @Override
    public void notifyObservateurInscription() {
    for (ObserveurInscription o : mObserveurs) {
        o.updateInscription();
    }

    }

    @Override
    public void notifyObservateurConnexion() {
        for (ObserveurInscription o : mObserveurs) {
            o.updateConnexion();
        }
    }

    @Override
    public void notifyObservateurConnecte() {

    }

	@Override
	public void notifyObserveurDeconnecte() {
		// TODO Auto-generated method stub
		
	}
	
}
