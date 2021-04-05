package authfromscratch.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="api/v1/auth")
public class UserController {
    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public List<UserMain> getUser() {
        return userServices.getUsers();
    }

    @PostMapping
    public String RegisterUser(@RequestBody UserMain userMain) {
        return userServices.registerUser(userMain);
    }

    @DeleteMapping(path="{email}")
    public String DeleteUser(@PathVariable String email) {
        return userServices.removeUserByEmail(email);
        //return UserServices.removeUserByEmail(email);
    }

    @PutMapping(path="/users/{email}")
    public String ChangePassword(@PathVariable String email,@RequestBody Map<String, Object> reqBody) {
        return userServices.changePassword(reqBody.get("new_password"), reqBody.get("old_password"), email);
    }

}