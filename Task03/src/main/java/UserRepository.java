import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    public List<User> data = new ArrayList<>();
    {
        data.add(new User("Ivan", "1111", false, true));
        data.add(new User("Petr", "2222", false, false));
        data.add(new User("Alex", "3333", false, false));
        data.add(new User("Semen", "4444", false, false));
    }

    public void addUser(User user) {
        if (user.name.isEmpty() || user.password.isEmpty()) {
            throw new RuntimeException("Empty fields");
        } else {
            data.add(user);
        }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public List<User> logoutUser(List<User> userLogout) {
        for (User user : userLogout) {
            if (!user.administrator && user.isAuthenticate){
                user.setAuthenticate(false);
            }
        }
        return userLogout;
    }
}