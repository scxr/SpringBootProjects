package com.example.anticancel.GetTweets;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class GetUserTweets {


    public JSONArray MakeRequest(String user, String extra) throws IOException, JSONException {
        int i;
        URL url = new URL(String.format("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=%s&count=200%s", user, extra));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        String BEARER = "AAAAAAAAAAAAAAAAAAAAAPfpHgEAAAAArsn7oyNyTcmEuECuYp020v2F6zk%3Dw6cMdSsdqEMLnyoROoZPZ8AE1QykurO0CHdQw6Bras5Gq4R5eb";
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

    public ArrayList<JSONArray> GetAllTweets() throws IOException, JSONException {
        ArrayList<JSONArray> resp = new ArrayList<>();
        JSONArray tmp;
        String lastID = null;
        int cnt=0;
        boolean gotAll = false;
        while (!gotAll) {
            if (lastID == null) {
                lastID = "99999999999999999999999999999999999999";
            }
            String extra = String.format("&max_id=%s&exclude_replies=false&include_rts=false", lastID);
            tmp = MakeRequest("ElonMusk", "");
            JSONObject lastVal = (JSONObject) tmp.get(tmp.length()-1);
            lastID = (String) lastVal.get("id_str");
            gotAll = true;
            resp.add(tmp);
            if (cnt==2) {
                gotAll=true;
            } else {
                cnt++;
            }

        }
        cnt=0;

        System.out.println(cnt);
        return resp;
    }

    public void main() throws IOException, JSONException {
        GetAllTweets();
    }
}
