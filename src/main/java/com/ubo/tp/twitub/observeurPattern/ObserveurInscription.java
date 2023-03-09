package main.java.com.ubo.tp.twitub.observeurPattern;

import main.java.com.ubo.tp.twitub.datamodel.User;

public interface ObserveurInscription {


    public void updateConnexion();

    void updateInscription();

    public void connecte(User user);
    
    public void deconnecte();

}

