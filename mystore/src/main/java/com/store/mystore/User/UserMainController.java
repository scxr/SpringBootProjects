package com.store.mystore.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "user/")
public class UserMainController {
    private final UserMainServices userMainServices;

    @Autowired
    public UserMainController(UserMainServices userMainServices) {
        this.userMainServices = userMainServices;
    }

    @GetMapping
    public List<UserMain> getUsers() {
        return this.userMainServices.getUsers();
    }


}
