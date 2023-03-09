package main.java.com.ubo.tp.twitub.controler;

import main.java.com.ubo.tp.twitub.datamodel.IDatabase;
import main.java.com.ubo.tp.twitub.datamodel.Twit;
import main.java.com.ubo.tp.twitub.datamodel.User;

public class CtrlAjoutTweet {




    public CtrlAjoutTweet() {


    }

    public void addTwit(String twit, User User,IDatabase mDatabase) {
        //Twit newTwit = new Twit(randomUser, twit);
        //mDatabase.addTwit(newTwit);
        Twit newTwit = new Twit(User, twit);
        mDatabase.addTwit(newTwit);
    }

}
