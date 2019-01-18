package com.google.networking;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView postsListView;
    private ProgressBar progressBar;

    private  PostAdapter adapter;
    private ArrayList<Post> allposts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postsListView = findViewById(R.id.posts);
        postsListView.setOnItemClickListener(this);
        progressBar = findViewById(R.id.progress);

        new AsyncTask<Void,Void,String>(){

            JsonParser parser = new JsonParser();

            @Override
            protected void onPreExecute() {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected String doInBackground(Void... voids) {

                String s = parser.getAllPosts("https://jsonplaceholder.typicode.com/posts");
                return s;
            }

            @Override
            protected void onPostExecute(String s) {
                progressBar.setVisibility(View.INVISIBLE);
                allposts = parser.convertDataToList(s);
                adapter = new PostAdapter(MainActivity.this,allposts);
                postsListView.setAdapter(adapter);}
        }.execute();






    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this,PostDetails.class);
        Post post = allposts.get(position);
        Log.e("post",post.getTitle());
        intent.putExtra("current_post",post);
        startActivity(intent);
    }
}
