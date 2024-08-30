package com.example.CustomerServicedemo;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.Customers.CustomerCare;

@SpringBootApplication
public class CustomerServicedemoApplication {

	public static void main(String[] args) {

		/*
		 * You need to complete this application as mentioned in the problem
		 * statement build your own logic and perform the following tasks.
		 * 
		 * Tasks:
		 * 1. Load the beans from ApplicationContext.xml
		 * 
		 * 2. Display all the departments available and get the input from user.
		 * 3. Get the message from user and store it into the respective department.
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		System.out.println("Welcome to our Customer Care Application");
		System.out.println("Please enter your name:");
		String customerName = sc.nextLine();
		System.out.println("Thanks for reaching us " + customerName + " ...");
		System.out.println("Please select a department to connect to:");
		System.out.println("1. Payment Department");
		System.out.println("2. Query Department");
		System.out.println("3. Sales Department");
		int choice = sc.nextInt();
		// CustomerCare customerCare;
		switch (choice) {
			case 1:
				CustomerCare customerCareP = (CustomerCare) context.getBean("paymentDepartment");
				customerCareP.setCustomerName(customerName);
				customerCareP.getService();
				break;
			case 2:
				CustomerCare customerCareQ = (CustomerCare) context.getBean("queryDepartment");
				customerCareQ.setCustomerName(customerName);
				customerCareQ.getService();
				break;
			case 3:
				CustomerCare customerCareS = (CustomerCare) context.getBean("salesDepartment");
				customerCareS.setCustomerName(customerName);
				customerCareS.getService();

				break;
			default:
				break;
		}
		context.close();
		sc.close();
	}
}
