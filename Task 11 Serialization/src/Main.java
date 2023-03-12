import java.io.*;
import java.util.*;
import java.util.ArrayList;

class User implements Serializable {
    private String firstName;
    private String lastName;
    private String personalNumber;

    public User(String firstName, String lastName, String personalNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalNumber = personalNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }
}



class UserSerializer {

    public void writeUsers(List<User> users) {
        try (FileOutputStream fos = new FileOutputStream("users.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> readUsers() {
        List<User> users = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("users.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            users = (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

}

public class Main {
    public static void main(String[] args) {
        UserSerializer serializer = new UserSerializer();

        List<User> users = new ArrayList<>();
        users.add(new User("John", "Doe", "1234567890"));
        users.add(new User("Jane", "Doe", "0987654321"));

        serializer.writeUsers(users);

        List<User> loadedUsers = serializer.readUsers();
        for (User user : loadedUsers) {
            System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getPersonalNumber());
            assert users.contains(user);
        }
    }
}