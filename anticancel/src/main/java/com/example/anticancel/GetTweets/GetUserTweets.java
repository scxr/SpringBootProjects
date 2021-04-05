package com.example.anticancel.GetTweets;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class GetUserTweets {


    public JSONArray MakeRequest(String user, Integer maxID) throws IOException, JSONException {
        int i;
        URL url = new URL(String.format("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=%s&count=200&max_id=%d", user, maxID));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        String BEARER = "";
        String auth = String.format("Bearer %s", BEARER);
        System.out.println(auth);
        connection.setRequestProperty("Authorization", auth);
        StringBuilder resp;

        try (BufferedReader inp = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            resp = new StringBuilder();
            while ((line = inp.readLine()) != null) {
                resp.append(line);
                resp.append(System.lineSeparator());
            }
        } finally {
            connection.disconnect();
        }
        String r = resp.toString();
//        System.out.println(r);
        return new JSONArray(r);
//        System.out.println(r_json);
    }
}
