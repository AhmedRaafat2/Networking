package com.google.networking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PostAdapter extends ArrayAdapter<Post> {
    private ArrayList<Post> posts;
    private Context context;

    public PostAdapter(Context context, ArrayList<Post> posts) {
        super(context, R.layout.custom_row, posts);
        this.posts = posts;
        this.context = context;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.custom_row,null,false);

        TextView userId = view.findViewById(R.id.userId);
        TextView postId = view.findViewById(R.id.postId);
        TextView postTitle = view.findViewById(R.id.title);
        TextView postBody = view.findViewById(R.id.body);

        Post post = posts.get(position);

        userId.setText(String.valueOf(post.getUserId()));
        postId.setText(String.valueOf(post.getId()));
        postTitle.setText(post.getTitle());
        postBody.setText(post.getBody());

        return view;
    }
}
