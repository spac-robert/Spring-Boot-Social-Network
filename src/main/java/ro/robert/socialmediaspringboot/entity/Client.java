package ro.robert.socialmediaspringboot.entity;

public class Client {
    private static User user;

    public Client(User user) {
        Client.user = user;
    }

    public static User getClient() {
        return user;
    }

    public static void setFriend(User from) {
        user.addFriend(from);
    }
}

