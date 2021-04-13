package com.store.mystore.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import javax.servlet.http.Cookie;
import java.security.Key;

public class Protection {

    public static String decodeJwt(String key, String jwts){
        SecretKey mykey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
        Claims r = Jwts.parserBuilder()
                .setSigningKey(mykey)
                .build()
                .parseClaimsJws(jwts)
                .getBody();
        return r.get("sub").toString();
    }

    public static String returnUser(Cookie[] cookies, String jwt_key) {
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("auth") & !cookie.getValue().equals("")) {
                return decodeJwt(jwt_key, cookie.getValue());
            }
        }
        return "na";
    }

    public static boolean isValidSignin(Cookie[] cookies, String jwt_key) {
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("auth") & !cookie.getValue().equals("")) {
                try {
                    Claims r = Jwts.parserBuilder()
                            .setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwt_key)))
                            .build()
                            .parseClaimsJws(cookie.getValue())
                            .getBody();
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }

    public static Cookie deleteCookie(Cookie cookie) {
        cookie.setValue("");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        return cookie;
    }
}
