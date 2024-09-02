package com.social.media.SocialMediaDemo;

import java.util.ArrayList;

public interface PostList {
    public ArrayList<Post> getAllPosts();
    public Post getPost(int i);
    public void setPost(Post p);
    public int size();


}
