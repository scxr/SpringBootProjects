package com.store.mystore.User;

import com.store.mystore.Product.ProductRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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
        try {
            this.userMainRepository.save(user);
            return "Added";
        } catch (Exception e) {
            return "Something went wrong "+e;
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



}
