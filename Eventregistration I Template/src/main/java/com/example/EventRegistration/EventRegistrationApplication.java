package com.example.EventRegistration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class EventRegistrationApplication {

	public static void main(String[] args) {
		// Import scanner and take ClassPathXmlApplicationContext.
		Scanner scanner=new Scanner(System.in);

		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

		// Take the college event bean from the application context.
		CollegeEvent event = (CollegeEvent) context.getBean("event");
		// Print the event details.
		System.out.println("Welcome to the Graduation Ceremony Registration Application");
		event.printEventDetails();


		while (true) {
			Attendee attendee=(Attendee) context.getBean("student");
			System.out.println("Do you want to register for the ceremony\n1. Yes\n2. No");
			int input = scanner.nextInt();
			scanner.nextLine();
			if (input == 1) {
				System.out.println("Please enter your name");
				String name=scanner.nextLine();
				System.out.println("Please enter your department");
				String dept=scanner.nextLine();
				System.out.println("In which year did you pass out?");
				int batch=scanner.nextInt();
				scanner.nextLine();
				attendee.setAttendeeDetails(name,dept,batch);
				event.registerStudent(attendee);
				attendee.printRegistrationConfirmation();
				/*
				 1. Take attendee details from the console.
				 2. Get studentAttendee bean from context and set the attendee details
				 3. Register the attendee for the event.
				 4. Print the registration confirmation.
				 */

			} else if(input == 2) {
				break;
			} else {
				System.out.println("Invalid Choice");
				return;
			}
		}

		// Get the number of attendees and print along with the statement below
		System.out.println("No. of attendees registered are: " + event.getAttendeeCount());
		System.out.println("The list of attendees are:");
		List<Attendee> allAttendees=event.getAllAttendees();
		for(Attendee tmp:allAttendees){
			System.out.println(tmp.getAttendeeName()+"       Reference Id: "+tmp);
		}
		// Print all the attendee names with their reference ids as given in the sample output..

	}

}
