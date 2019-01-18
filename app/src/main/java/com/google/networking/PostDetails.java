package com.google.networking;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

public class PostDetails extends AppCompatActivity implements View.OnClickListener {

    private TextView user_id,post_id,post_title,post_body;
    private Button comment_Button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_details);

        comment_Button = findViewById(R.id.view_comments);
        comment_Button.setOnClickListener(this);

        user_id = findViewById(R.id.userId);
        post_id = findViewById(R.id.postId);
        post_title = findViewById(R.id.title);
        post_body = findViewById(R.id.body);

        Intent intent = getIntent();
        Post post = (Post) intent.getSerializableExtra("current_post");

        user_id.setText("UserID :"+String.valueOf(post.getUserId()));
        post_id.setText("PostID :"+String.valueOf(post.getId()));
        post_title.setText("Title :"+post.getTitle());
        post_body.setText("Post Body :-\n"+post.getBody());
    }

    @Override
    public void onClick(View v) {
        Intent intent = getIntent();
        Post post = (Post) intent.getSerializableExtra("current_post");

        Intent intent1 = new Intent(this,Comments.class);
        intent1.putExtra("current_post",post);
        startActivity(intent1);
    }
}
