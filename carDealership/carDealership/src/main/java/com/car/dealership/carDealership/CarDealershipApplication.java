package com.car.dealership.carDealership;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class CarDealershipApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CarDealershipApplication.class, args);
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Scanner sc=new Scanner(System.in);
		System.out.println("Hi.. Pleaes enter your name");
		String name=sc.nextLine();
		System.out.println("Please select a car of your choice: ");
		System.out.println("1. Family Car\n2. Sports Car\n3. Truck");
		int choice=sc.nextInt();
		String carChoiceStr="";
		if(choice==1)
			carChoiceStr="familyCar";
		if(choice==2)
			carChoiceStr="sportsCar";
		if(choice==3)
			carChoiceStr="truck";
		int tyreChoice;
		System.out.println("Enter tyre type: ");
		System.out.println("1. Normal Tyres\n2. Sports Tyre\n3. Heavy Tyres");
		tyreChoice=sc.nextInt();
		String tyreChoiceStr="";
		if(tyreChoice==1)
			tyreChoiceStr="WithNormalTyre";
		if(tyreChoice==2)
			tyreChoiceStr="WithSportsTyre";
		if(tyreChoice==3)
			tyreChoiceStr="WithHeavyTyre";
		Car car=null;
		car=(Car) context.getBean(carChoiceStr+tyreChoiceStr);
		car.setOwnerName(name);
		System.out.println(car.getOwnerName()+" owns a"+car.getInfo()+" ");
		
	}

}
