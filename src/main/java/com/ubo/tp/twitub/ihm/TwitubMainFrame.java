package main.java.com.ubo.tp.twitub.ihm;

import main.java.com.ubo.tp.twitub.controler.CtrlConnexion;
import main.java.com.ubo.tp.twitub.datamodel.User;
import main.java.com.ubo.tp.twitub.observeurPattern.ObservableInscriptionConnexion;
import main.java.com.ubo.tp.twitub.observeurPattern.ObserveurInscription;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe de la vue principale de l'application.
 */
public class TwitubMainFrame extends JFrame {

/**
 * Constructeur.
 */
public TwitubMainFrame(JMenuBar menu) {

    this.setJMenuBar(menu);
    this.setTitle("Twitub");
    this.setSize(300, 200);
    this.setVisible(true);
}

     public void addandvalide(JPanel monPanel) {
         this.setContentPane(monPanel);
         this.validate();
     }

    
}