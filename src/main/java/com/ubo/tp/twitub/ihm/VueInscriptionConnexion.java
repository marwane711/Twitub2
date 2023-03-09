package main.java.com.ubo.tp.twitub.ihm;

import javax.swing.*;
import java.awt.*;

public class VueInscriptionConnexion extends JPanel{

   // protected Set<IObserveurConnexPage> listObservers = new HashSet<IObserveurConnexPage>();
    public VueInscriptionConnexion(){
        boutonInscriptionConnexion();
    }

    public void boutonInscriptionConnexion() {

        System.out.println("test");
        // Crée une grille 1x2 avec des marges horizontales et verticales de 10 pixels
        GridLayout layout = new GridLayout(1, 2, 10, 10);
        this.setLayout(layout);
        JButton buttonInscription = new JButton("Inscription");
        buttonInscription.setPreferredSize(new Dimension(100, 50));
        this.add(buttonInscription);
       // buttonInscription.addActionListener( e -> inscription());
        JButton buttonConnexion = new JButton("Connexion");
        buttonConnexion.setPreferredSize(new Dimension(100, 50));
        this.add(buttonConnexion);
        this.setVisible(true);
       // buttonConnexion.addActionListener( e -> openConnexionFrame());

    }




}
