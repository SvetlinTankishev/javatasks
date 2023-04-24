import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("John", "Does", "9105069242"));
        users.add(new User("Jane", "Doesnt", "9202035535"));

        UserSerializer.writeUsers(users, "users.dat");

        List<User> readUsers = UserSerializer.readUsers("users.dat");
        for (User user : readUsers) {
            System.out.println(user.toString());
        }
    }
}