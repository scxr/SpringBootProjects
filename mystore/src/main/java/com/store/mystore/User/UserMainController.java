package com.store.mystore.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "user/")
public class UserMainController {

    @GetMapping
    public static List<UserMain> getUsers() {
        return UserMainServices.getUsers();
    }


}
