import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private static UserRepository userRepository;
    private static User user;

    @BeforeAll
    static void setUp() {
        user = new User(null, null, false, false);
        userRepository = new UserRepository();
    }

    @Test
    void addPerson() {
        int counter = userRepository.data.size();
        userRepository.addUser(new User("Elena", "5555", false, false));
        assertTrue(1 == userRepository.data.size() - counter);
    }

    @Test
    void emptyFieldsUserName() {
        assertThatThrownBy(() ->
                userRepository.addUser(new User("", "6666", false, false))
        ).isInstanceOf(RuntimeException.class).hasMessage("Empty fields");
    }

    @Test
    void emptyFieldsUserPassword() {
        assertThatThrownBy(() ->
                userRepository.addUser(new User("Olga", "", false, false))
        ).isInstanceOf(RuntimeException.class).hasMessage("Empty fields");
    }

    @Test
    void emptyFieldsUserNameAndPassword() {
        assertThatThrownBy(() ->
                userRepository.addUser(new User("", "", false, false))
        ).isInstanceOf(RuntimeException.class).hasMessage("Empty fields");
    }

    @Test
    void findExistPersonIntoList() {
        assertTrue(userRepository.findByName("Petr"));
    }

    @Test
    void findNotExistPersonInList() {
        assertFalse(userRepository.findByName("Olga"));
    }

    @Test
    void authenticateValidPerson() {
        assertTrue(user.authenticate("Ivan", "1111"));
    }

    @Test
    void authenticateNotValidPersonPassword() {
        assertFalse(user.authenticate("Ivan", "1122"));
    }

    @Test
    void authenticateNotValidPerson() {
        assertFalse(user.authenticate("Olga", "6666"));
    }

    @Test
    void logoutPerson() {
        List<User> dataTesting = new ArrayList<>();
        dataTesting.addAll(userRepository.data);
        for (User user : dataTesting) {
            user.setAuthenticate(true);
        }
        dataTesting = userRepository.logoutUser(dataTesting);
        for (User user : dataTesting) {
            if (!user.administrator) {
                assertFalse(user.isAuthenticate);
            } else {
                assertTrue(user.isAuthenticate);
            }
        }
    }
}