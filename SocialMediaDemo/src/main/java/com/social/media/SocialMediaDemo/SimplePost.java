package com.social.media.SocialMediaDemo;

public class SimplePost implements Post{
    String message;
    @Override
    public void setMessage(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
