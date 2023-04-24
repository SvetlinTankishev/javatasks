import java.io.Serial;
import java.io.Serializable;


public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final String firstName;
    private final String lastName;
    private final String personalNumber;

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

    @Override
    public String toString() {
        return "User{" +
                "First Name = '" + firstName + '\'' +
                ", Last Name = '" + lastName + '\'' +
                ", EGN = '" + personalNumber + '\'' +
                '}';
    }
}
