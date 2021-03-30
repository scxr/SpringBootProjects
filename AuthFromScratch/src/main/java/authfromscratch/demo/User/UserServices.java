package authfromscratch.demo.User;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class UserServices {


    private static List<User> users = new ArrayList<User>();

    public static List<User> getUsers() {
        return users;
    }

    public static String registerUser(User user) {
        users.add(user);
        return "User added";
    }
    //private static ListIterator<User> userListIterator = users.listIterator();
    public static String removeUserByEmail(Object email) {
        for (User user : users) {
            if (user.getEmail().equals(email.toString())) {
                users.remove(user);
                return "Removed";
            }
        }
        return "User does not exist with that email";
    }

    public static String changePassword(Object newPassword, Object oldPassword, String email) {

        for (User user: users) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(oldPassword.toString())) {
                    user.setPassword(newPassword.toString());
                    return "Password changed";
                } else {
                    return oldPassword.toString() + ' ' + user.getPassword();
                    //return "Incorrect password";
                }
            }
        }
        return "User not found";

    }

}
