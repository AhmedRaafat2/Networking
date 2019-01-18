package com.google.networking;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class Comments extends AppCompatActivity {
    private ListView commentsListView;
    String commentsUrl = "https://jsonplaceholder.typicode.com/comments?postId=";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comments);

        commentsListView = findViewById(R.id.comments_listview);

        Intent intent = getIntent();
        final Post post = (Post) intent.getSerializableExtra("current_post");


        new AsyncTask<Void,Void,String>(){

            JsonParser parser = new JsonParser();

            @Override
            protected void onPreExecute() {
            }

            @Override
            protected String doInBackground(Void... voids) {
                String s = parser.getAllPosts(commentsUrl+post.getId());
                return s;
            }

            @Override
            protected void onPostExecute(String s) {

                Log.e("comments",s);
            }
        }.execute();


    }
}
