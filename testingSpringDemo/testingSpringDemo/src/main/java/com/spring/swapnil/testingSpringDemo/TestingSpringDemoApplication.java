package com.spring.swapnil.testingSpringDemo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class TestingSpringDemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(TestingSpringDemoApplication.class, args);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of table");
		String size = sc.next();
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Table longTable = (Table) ctx.getBean("longTable");
		Table shortTable = (Table) ctx.getBean("shortTable");
		if (size.equals("long")) {
			System.out.println(longTable.showDetails());
		} else {
			System.out.println(shortTable.showDetails());
		}
	}

}
