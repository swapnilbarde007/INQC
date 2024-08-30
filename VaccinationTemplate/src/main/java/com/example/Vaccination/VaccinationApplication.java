package com.example.Vaccination;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@SpringBootApplication
public class VaccinationApplication {
	static boolean promptAgain=true;
	static Scanner sc;
    public static void main(String[] args) {
    	
        /*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

		 Tasks:
		1. Fetch context from ApplicationContext.xml and initiate Scanner.
		2. Fetch vaccine and User type choice.
		3. Get the required bean from context.
		4. Get the appointment details form user
		5. Display the appointment details
		6. Run the loop again to book for another user or else exit.
		 */
    	
    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	sc=new Scanner(System.in);
    	while(promptAgain) {
    		vaccineAppRunner(context,sc);
    	}
    	
    }
    public static void vaccineAppRunner(ClassPathXmlApplicationContext context,Scanner sc) {
    	
    	System.out.println("Welcome to the Vaccination Application");
    	System.out.println("Please choose your vaccine preference");
    	System.out.println("1. Covid");
    	System.out.println("2. Polio");
    	System.out.println("3. Tyhoid");
    	int vaccineChoice=sc.nextInt();
    	String vaccineChoiceStr;
    	switch(vaccineChoice) {
    	case 1:
    		vaccineChoiceStr="Covid";
    	break;
    	case 2:
    		vaccineChoiceStr="Polio";
        break;
    	case 3:
    		vaccineChoiceStr="Typhoid";
        break;
    	default:
    		System.out.println("Invalid Choice");
    		return;
    	}
    	System.out.println("Whom do you want to vaccinate");
    	System.out.println("1. Father");
    	System.out.println("2. Mother");
    	System.out.println("3. Self");
    	System.out.println("4. Spouse");
    	System.out.println("5. Exit");
    	int relativeChoice=sc.nextInt();
    	String relativeChoiceStr;
    	switch(relativeChoice) {
    	case(1):
    		relativeChoiceStr="father";
    	break;
    	case(2):
    		relativeChoiceStr="mother";
    	break;
    	case(3):
    		relativeChoiceStr="Self";
    	break;
    	case(4):
    		relativeChoiceStr="spouse";
    	break;
    	case(5):
    		System.out.println("Exiting...");
    		return;
    	default:
    		System.out.println("Invalid Choice. Exiting...");
    		return;
    	}
    	String tmp=relativeChoiceStr.substring(0,1).toUpperCase()+relativeChoiceStr.substring(1);
    	sc.nextLine();
    	System.out.println("Please enter "+tmp+" details: ");
    	System.out.println("Name: ");
    	String name=sc.nextLine();
    	System.out.println("Age: ");
    	int age=sc.nextInt();
    	sc.nextLine();
    	System.out.println("Appointment Date (YYYY-MM-DD): ");
    	String appoinDate=sc.nextLine();
    	System.out.println("Appointment Time (HH:MM AM/PM): ");
    	String appoinTime=sc.nextLine();
    	System.out.println("Appointment Location: ");
    	String appoinLoc=sc.nextLine();
    	
    	TimeAndLocation timeAndLocation=(TimeAndLocation) context.getBean("timeAndLocation");
    	timeAndLocation.setDetails(appoinTime, appoinLoc, appoinDate);
    	
    	User user=(User) context.getBean(relativeChoiceStr+vaccineChoiceStr);
    	user.setUserDetails(name, age);
    	user.setAppointment();
    	System.out.println("Do you want to register for someone Else");
    	System.out.println("1. Yes");
    	System.out.println("2. No");
    	int newApp=sc.nextInt();
    	if(newApp==2) {
    		promptAgain=false;
    	}
    }
}