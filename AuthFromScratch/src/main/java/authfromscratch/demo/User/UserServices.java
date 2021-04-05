package authfromscratch.demo.User;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices {


    private static final List<UserMain> userMains = new ArrayList<>();

    public static List<UserMain> getUsers() {
        return userMains;
    }

    public static String registerUser(UserMain userMain) {
        userMains.add(userMain);
        return "User added";
    }
    //private static ListIterator<User> userListIterator = users.listIterator();
    public static String removeUserByEmail(Object email) {
        for (UserMain userMain : userMains) {
            if (userMain.getEmail().equals(email.toString())) {
                userMains.remove(userMain);
                return "Removed";
            }
        }
        return "User does not exist with that email";
    }

    public static String changePassword(Object newPassword, Object oldPassword, String email) {

        for (UserMain userMain : userMains) {
            if (userMain.getEmail().equals(email)) {
                if (userMain.getPassword().equals(oldPassword.toString())) {
                    userMain.setPassword(newPassword.toString());
                    return "Password changed";
                } else {
                    return oldPassword.toString() + ' ' + userMain.getPassword();
                    //return "Incorrect password";
                }
            }
        }
        return "User not found";

    }

}
