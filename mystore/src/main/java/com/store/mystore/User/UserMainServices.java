package com.store.mystore.User;

import com.store.mystore.Product.ProductRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.crypto.SecretKey;
import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserMainServices {
//    private static final List<UserMain> users = new ArrayList<UserMain>();
    private final UserMainRepository userMainRepository;

    @Bean
    public BcryptPasswordEncoder bcryptPasswordEncoder() {
        return new BcryptPasswordEncoder();
    }

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
            String hashedPword = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
            this.userMainRepository.changePassword(hashedPword, id);
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

    public String generateJwt(String username, String key) {
        SecretKey mykey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
        return Jwts.builder().setSubject(username).signWith(mykey).compact();
    }

    public String decodeJwt(String key, String jwts){
        SecretKey mykey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
        Claims r = Jwts.parserBuilder()
                .setSigningKey(mykey)
                .build()
                .parseClaimsJws(jwts)
                .getBody();
        return r.get("sub").toString();
    }

}
