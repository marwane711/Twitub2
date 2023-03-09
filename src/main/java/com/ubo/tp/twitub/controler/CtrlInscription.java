package main.java.com.ubo.tp.twitub.controler;

import main.java.com.ubo.tp.twitub.core.EntityManager;
import main.java.com.ubo.tp.twitub.datamodel.IDatabase;
import main.java.com.ubo.tp.twitub.datamodel.Twit;
import main.java.com.ubo.tp.twitub.datamodel.User;

import java.util.HashSet;
import java.util.UUID;

public class CtrlInscription {
    protected IDatabase mDatabase;
    protected EntityManager mEntityManager;


    public CtrlInscription(IDatabase mDatabase, EntityManager mEntityManager) {
        this.mDatabase = mDatabase;
        this.mEntityManager = mEntityManager;
    }


    public boolean createUsers(String tag, String mdp, String name) {

        User user = null;
        for(User u : this.mDatabase.getUsers()) {
            if(u.getUserTag().equals(tag)) {
                user = u;
                System.out.println("Existe déja");

            }
        }
        if(user == null) {
            User monUser = new User(UUID.randomUUID(), tag, mdp, name, new HashSet<>(), "");
            this.mDatabase.addUser(monUser);
            System.out.println("Utilisateur créé");
            return true;
        }
        else {
            System.out.println("Utilisateur non créé");
            return false;
        }



    }

}
