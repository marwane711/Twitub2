package main.java.com.ubo.tp.twitub.observeurPattern;

public interface ObservableTwit {
	
	public void addObserveur(ObserveurTwit o);
    public void removeObserveur(ObserveurTwit o);
    public void notifyObserveurs(String text);

}
