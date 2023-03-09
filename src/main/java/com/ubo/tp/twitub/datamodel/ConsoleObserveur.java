package main.java.com.ubo.tp.twitub.datamodel;

public class ConsoleObserveur implements IDatabaseObserver{

    @Override
    public void notifyTwitAdded(Twit addedTwit) {
        System.out.println("Twit added : " + addedTwit);
    }

    @Override
    public void notifyTwitDeleted(Twit deletedTwit) {
        System.out.println("Twit deleted : " + deletedTwit);


    }

    @Override
    public void notifyTwitModified(Twit modifiedTwit) {
        System.out.println("Twit modified : " + modifiedTwit);


    }

    @Override
    public void notifyUserAdded(User addedUser) {
        System.out.println("User added : " + addedUser);

    }

    @Override
    public void notifyUserDeleted(User deletedUser) {
        System.out.println("User deleted : " + deletedUser);

    }

    @Override
    public void notifyUserModified(User modifiedUser) {
        System.out.println("User modified : " + modifiedUser);

    }
}
