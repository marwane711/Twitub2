package main.java.com.ubo.tp.twitub.ihm;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import main.java.com.ubo.tp.twitub.observeurPattern.ObservableInscriptionConnexion;
import main.java.com.ubo.tp.twitub.observeurPattern.ObservableTwit;
import main.java.com.ubo.tp.twitub.observeurPattern.ObserveurInscription;
import main.java.com.ubo.tp.twitub.observeurPattern.ObserveurTwit;

public class MenuConnecte extends JMenuBar implements ObservableTwit, ObservableInscriptionConnexion{

	Set<ObserveurTwit> mObserveursTwit;
    Set<ObserveurInscription> mObserveursCo;
	
	public MenuConnecte() {   
		
		this.mObserveursTwit = new HashSet<ObserveurTwit>();
		this.mObserveursCo = new HashSet<ObserveurInscription>();
		
        JMenuItem menuItem = new JMenuItem("Profile");
        this.add(menuItem);
        menuItem.addActionListener(e -> notifyObservateurConnecte());

        JMenuItem lesTwits = new JMenuItem("Les twits");
        this.add(lesTwits);
        lesTwits.addActionListener(e -> notifyObserveurs(null));
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
	public void notifyObserveurs(String text) {
		for(ObserveurTwit o : this.mObserveursTwit) {
			o.updateVueTwits(null);
		}
	}

	@Override
	public void addObservateur(ObserveurInscription o) {
		this.mObserveursCo.add(o);
	}

	@Override
	public void notifyObservateurConnecte() {
		System.out.println(this.mObserveursCo);
		for(ObserveurInscription o : this.mObserveursCo) {
			o.connecte(null);
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
	public void notifyObserveurDeconnecte() {
		// TODO Auto-generated method stub
		
	}
}
