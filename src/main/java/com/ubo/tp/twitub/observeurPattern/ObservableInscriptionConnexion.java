package main.java.com.ubo.tp.twitub.observeurPattern;

public interface ObservableInscriptionConnexion {

    public void addObservateur(ObserveurInscription o);
    public void removeObservateur(ObserveurInscription o);
    public void notifyObservateurInscription();
    public void notifyObservateurConnexion();
    public void notifyObservateurConnecte();
    public void notifyObserveurDeconnecte();
}
