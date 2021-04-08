package com.store.mystore.User;

import com.store.mystore.Product.ProductRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserMainServices {
//    private static final List<UserMain> users = new ArrayList<UserMain>();
    private final UserMainRepository userMainRepository;

    @Autowired
    public UserMainServices (UserMainRepository userMainRepository) {
        this.userMainRepository = userMainRepository;
    }
    public List<UserMain> getUsers() {
        return this.userMainRepository.findAll();
    }

    public String addUser(UserMain user) {
        Optional<UserMain> u = this.userMainRepository.checkByUname(user.getUsername());
        if (u.isEmpty()) {
            try {
                String hashedPword = DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8));
                user.setPassword(hashedPword);
                this.userMainRepository.save(user);
                return "Added";
            } catch (Exception e) {
                return "Something went wrong "+e;
            }
        } else {
            return "Username is taken";
        }


    }

    public String removeUser(long id) {
        for (UserMain u: getUsers()) {
            if (u.getUserID() == id) {
                this.userMainRepository.delete(u);
                return "deleted user";
            }
        }
        return "Could not find user";
    }

    @Transactional
    public String changePassword(long id, String password) {
        try {
            this.userMainRepository.changePassword(password, id);
            return "Password changed";
        } catch (Exception e) {
            return "Something went wrong" + e;
        }
    }

    public String getUser(long id){
        Optional<UserMain> u = this.userMainRepository.checkById(id);
        if (u.isEmpty()){
            return "No user with this id";
        }
        return u.toString();
    }

    public String login(String username, String password) {
        Optional<UserMain> u = this.userMainRepository.checkByUname(username);
        if (u.isPresent()) {
            UserMain n = u.get();
            String actualPassword = n.getPassword();
            if (actualPassword.equals(DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))) {
                return "login successful";
            } else {
                return "incorrect password";
            }
        }
        return "User not found";
     }


}
