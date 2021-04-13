package com.store.mystore.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


@Controller
@RequestMapping(path="users/")
public class UserMainControllerRestless {
    private UserMainServices userMainServices;
    Resource resource = new ClassPathResource("/application.properties");
    Properties props = PropertiesLoaderUtils.loadProperties(resource);
    private final String key = props.getProperty("jwt_key");

    @Autowired
    public UserMainControllerRestless(UserMainServices userMainServices) throws IOException {
        this.userMainServices = userMainServices;
    }

    @GetMapping("all_users")
    public String getAllUsers(Model model) {
        List<UserMain> users = this.userMainServices.getUsers();
        model.addAttribute("users", users);
        return "userListing";
    }

    @GetMapping("register_user")
    public String registerUserGet(Model model) {

        model.addAttribute("user", new UserMain());
        return "userRegister";
    }

    @PostMapping("register_user")
    public String registerUser(@ModelAttribute("user") UserMain user, Model model) {
        this.userMainServices.addUser(user);
        return getAllUsers(model);
    }

    @DeleteMapping("delete_user/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        this.userMainServices.removeUser(id);
        return getAllUsers(model);
    }

    @PostMapping("change_password")
    public String changePassword(@ModelAttribute("id") long id, @ModelAttribute("newPassword") String newPassword, Model model){
        this.userMainServices.changePassword(id, newPassword);
        return getAllUsers(model);
    }

    @GetMapping("change_password")
    public String changePasswordGet(Model model) {
        model.addAttribute("user", new UserMain());
        return "changePassword";
    }

    @GetMapping("login")
    public String loginGet(Model model) {
        model.addAttribute("user", new UserMain());
        return "login";
    }


    @PostMapping("login")
    public String login(Model model, @ModelAttribute("user") UserMain userMain, HttpServletResponse response) throws IOException {
        String rsp = this.userMainServices.login(userMain.getUsername(), userMain.getPassword());
        if (rsp.equals("login successful")) {
            String jwt = this.userMainServices.generateJwt(userMain.getUsername(), this.key);
            Cookie cookie = new Cookie("auth", jwt);
            cookie.setMaxAge(4000);
            cookie.setPath("/");
            response.addCookie(cookie);
            return "success";
        } else {
            model.addAttribute("error", rsp);
            return "login";
        }
    }

    @GetMapping("protected")
    public String protectedEndpoint(HttpServletRequest request, Model model) {
        Cookie[] cookies = request.getCookies();
        String user = this.userMainServices.returnUser(cookies, this.key);
        if (user.equals("na")) {
            model.addAttribute("error", "You need to be signed in to view that page");
            return loginGet(model);
        } else {
            model.addAttribute("user", user);
            return "protected";
        }
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            if(cookie.getName().equals("auth")) {
                cookie.setValue("");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                break;
            }
        }
        return loginGet(model);
    }

}
