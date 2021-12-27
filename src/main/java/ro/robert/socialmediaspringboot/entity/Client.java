package ro.robert.socialmediaspringboot.entity;

public class Client {
    private static User user;

    public Client(User user) {
        Client.user = user;
    }

    public static User getClient() {
        return user;
    }
}
