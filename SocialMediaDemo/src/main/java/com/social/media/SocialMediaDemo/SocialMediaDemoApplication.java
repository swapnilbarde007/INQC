package com.social.media.SocialMediaDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;
import java.util.Scanner;

@SpringBootApplication
public class SocialMediaDemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SocialMediaDemoApplication.class, args);
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Post simplePost=(Post) context.getBean("simplePost");
		System.out.println("Social Media App Started...");
		Scanner sc=new Scanner(System.in);
		System.out.println();
		boolean reExecute=true;
		int menuChoice=0;
		PostList postlist = (PostList) context.getBean("simplePostList");
		User user=null;
		while(reExecute){

			System.out.println("1. Make new post");
			System.out.println("2. Show all posts");
			System.out.println("3. Exit");
			menuChoice=sc.nextInt();
			sc.nextLine();
			switch(menuChoice){
				case(1):
					Post post=(Post) context.getBean("simplePost");
					System.out.println("Enter post text: ");
					String postText=sc.nextLine();
					post.setMessage(postText);
					postlist.setPost(post);
					user=(User) context.getBean("user");
					user.setUserName("Swapnil");
					user.setPostList(postlist);
					break;
				case(2):
					System.out.println("All The Posts for user: "+user.getUserName());

					for(Post tmpPost: user.getPostList().getAllPosts()){
						System.out.println(tmpPost.getMessage());
					}
					break;
				case(3):
					reExecute=false;
					break;
			}
		}
	}

}
