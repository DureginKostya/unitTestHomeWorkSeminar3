public class User {
    String name;
    String password;
    boolean isAuthenticate = false;
    boolean administrator;

    public User(String name, String password, boolean isAdmin, boolean isAdministrator) {
        this.name = name;
        this.password = password;
        this.administrator = isAdministrator;
    }
    //3.6.
    public boolean authenticate(String name, String password) {
        UserRepository userRepository = new UserRepository();
        if (userRepository.findByName(name)) {
            for (User user : userRepository.data) {
                if (user.name.equals(name) && user.password.equals(password)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void setAuthenticate(boolean authenticate) {
        isAuthenticate = authenticate;
    }
}
