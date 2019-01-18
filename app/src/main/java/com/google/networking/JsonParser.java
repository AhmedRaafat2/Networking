package com.google.networking;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class JsonParser {

    public String getAllPosts(String url_link){

        StringBuilder postsStringBuilder = new StringBuilder();
        try {
            URL url = new URL(url_link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if(connection.getResponseCode() == 200){
                Scanner scanner = new Scanner(connection.getInputStream());
                while (scanner.hasNextLine()){
                    postsStringBuilder.append(scanner.nextLine());
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return postsStringBuilder.toString();
    }

    public ArrayList<Post> convertDataToList(String data){
        ArrayList<Post> allPosts = new ArrayList<>();

        try {
            JSONArray allPostsJson = new JSONArray(data);
            JSONObject postJson;
            Post post;

            for(int i =0;i<allPostsJson.length();i++){
                postJson = (JSONObject) allPostsJson.get(i);

                int userId = postJson.getInt("userId");
                int id = postJson.getInt("id");
                String title = postJson.getString("title");
                String body = postJson.getString("body");

                post = new Post(userId,id,title,body);
                allPosts.add(post);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return allPosts;
    }
}
