package main.java.com.ubo.tp.twitub.controler;

import main.java.com.ubo.tp.twitub.datamodel.Database;

public class CtrlVueTweet {

    public CtrlVueTweet(Database mDatabase) {

        for (int i = 0; i < mDatabase.getTwits().size(); i++) {
            System.out.println(mDatabase.getTwits());
        }


    }

}
