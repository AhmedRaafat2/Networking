package com.google.networking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView postsListView;

    private  PostAdapter adapter;
    private ArrayList<Post> allposts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postsListView = findViewById(R.id.posts);

        allposts = new ArrayList<>();
        allposts.add(new Post(1,10,"title","body"));
        allposts.add(new Post(2,20,"title","body"));
        allposts.add(new Post(3,30,"title","body"));

        adapter = new PostAdapter(this,allposts);

        postsListView.setAdapter(adapter);

    }
}
