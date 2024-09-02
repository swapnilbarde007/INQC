package com.social.media.SocialMediaDemo;

public class UserImpl implements User{
    String userName;
    PostList postList;

    @Override
    public void setUserName(String userName) {
        this.userName=userName;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public PostList getPostList() {
        return this.postList;
    }

    @Override
    public void setPostList(PostList p) {
        this.postList=p;
    }
}
