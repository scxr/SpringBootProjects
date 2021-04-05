package com.example.anticancel;

import com.example.anticancel.GetTweets.GetUserTweets;
import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AnticancelApplication {

    public static void main(String[] args) throws IOException, JSONException {
        GetUserTweets obj = new GetUserTweets();
        obj.main();
        SpringApplication.run(AnticancelApplication.class, args);
    }
}
