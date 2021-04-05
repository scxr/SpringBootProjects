package com.store.mystore.User;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMainServices {
    private static final List<UserMain> users = new ArrayList<UserMain>();

    public static List<UserMain> getUsers() {
        return users;
    }




}
