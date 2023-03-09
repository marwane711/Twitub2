package main.java.com.ubo.tp.twitub.observeurPattern;

import java.util.Set;

import main.java.com.ubo.tp.twitub.datamodel.Twit;

public interface ObserveurTwit {

	public void updateVueTwits(Set<Twit> twits);
	public void newTwitSent(String twitText);
	public void myTwits();
}
