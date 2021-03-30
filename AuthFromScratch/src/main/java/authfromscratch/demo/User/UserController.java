package authfromscratch.demo.User;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="api/v1/auth")
public class UserController {
    @GetMapping
    public List<User> getUser() {
        return UserServices.getUsers();
    }

    @PostMapping
    public String RegisterUser(@RequestBody User user) {
        return UserServices.registerUser(user);
    }

    @DeleteMapping(path="{email}")
    public String DeleteUser(@PathVariable String email) {
        return UserServices.removeUserByEmail(email);
        //return UserServices.removeUserByEmail(email);
    }

    @PutMapping(path="/users/{email}")
    public String ChangePassword(@PathVariable String email,@RequestBody Map<String, Object> reqBody) {
        return UserServices.changePassword(reqBody.get("new_password"), reqBody.get("old_password"), email);
    }

}