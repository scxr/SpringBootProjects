package com.store.mystore.User;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping(path="add_user")
    public String addUser(@RequestBody UserMain user) {
        return this.userMainServices.addUser(user);
    }

    @PutMapping(path="change_password/{id}")
    public String changePassword(@PathVariable long id, @RequestBody Map<String, String> req) {
        return this.userMainServices.changePassword(id, req.get("newPassword"));
    }

    @GetMapping(path = "get_user/{id}")
    public String checkUser(@PathVariable long id){
        return this.userMainServices.getUser(id);
    }


    @PostMapping(path="login")
    public String login(@RequestBody UserMain user) {
        return this.userMainServices.login(user.getUsername(), user.getPasswords());
    }

    @DeleteMapping(path = "delete_user/{id}")
    public String delete(@PathVariable long id) {
        return this.userMainServices.removeUser(id);

    }


}
