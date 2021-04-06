package com.store.mystore.User;

import com.store.mystore.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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




}
