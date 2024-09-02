package com.social.media.SocialMediaDemo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SimplePostList implements PostList{
    ArrayList<Post> postList;

    public SimplePostList() {
        this.postList = new ArrayList<>();
    }

    @Override
    public ArrayList<Post> getAllPosts() {
        return this.postList;
    }

    @Override
    public Post getPost(int i) {
        return this.postList.get(i);
    }

    @Override
    public void setPost(Post p) {
        this.postList.add(p);
    }

    @Override
    public int size() {
        return this.postList.size();
    }
}
