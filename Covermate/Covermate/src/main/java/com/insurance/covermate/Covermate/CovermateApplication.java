package com.insurance.covermate.Covermate;

import com.insurance.covermate.Covermate.Entities.Customer;
import com.insurance.covermate.Covermate.Entities.Insurance;
import com.insurance.covermate.Covermate.Impl.HealthInsurance;
import com.insurance.covermate.Covermate.Impl.TermInsurance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Scanner;

@SpringBootApplication
public class CovermateApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//SpringApplication.run(CovermateApplication.class, args);
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Insurance Application");
		System.out.println("What is your name?");
		String name=sc.nextLine();
		System.out.println("What is your age?");
		int age=sc.nextInt();
		sc.nextLine();
		System.out.println("Which insurance do you want?");
		System.out.println("1 - Health Insurance");
		System.out.println("2 - Term Insurance");
		int insuranceChoice=sc.nextInt();
		HashMap<Integer,String> insuranceTypes=new HashMap<>();
		insuranceTypes.put(1,"Health Insurance");
		insuranceTypes.put(2,"Term Insurance");
		sc.nextLine();
		Customer customer=null;

		if(insuranceChoice==1){
			System.out.println("You have chosen "+insuranceTypes.get(1));
			System.out.println("Are you a Drinker? Y or N");
			String drinkStr=sc.nextLine();
			boolean drinker=false,smoker=false,priorHealthCond=false;
			if(drinkStr.contentEquals("Y")){
				drinker=true;
			}
			System.out.println("Are you a Smoker? Y or N");
			String smokeStr=sc.nextLine();
			if(smokeStr.contentEquals("Y")){
				smoker=true;
			}
			System.out.println("Do you have any prior health condition? Y or N");
			String priorHealth=sc.nextLine();
			if(priorHealth.contentEquals("Y")){
				priorHealthCond=true;
			}
			HealthInsurance healthInsurance=(HealthInsurance) context.getBean("healthInsurance");
			healthInsurance.setInsurenceDetails(smoker,drinker,priorHealthCond);
			customer=(Customer) context.getBean("customerWithHealthInsurance");
			customer.setName(name);
			customer.setAge(age);

			System.out.println("Hi "+customer.getName()+
					" You have a "+customer.getInsurance().getInsuranceName()+
					"  Premium of "+customer.getInsurance().getInsurancePremium());
		}else{
			Insurance inr=(Insurance) context.getBean("termInsurance");
			System.out.println("You have chosen "+insuranceTypes.get(2));
			System.out.println("Are you a Salaried? Y or N");
			String salStr=sc.nextLine();
			boolean salaried=false,hasChild=false,married=false;
			if(salStr.contentEquals("Y")){
				salaried=true;
			}
			System.out.println("Are you a Married? Y or N");
			String marriedStr=sc.nextLine();
			if(marriedStr.contentEquals("Y")){
				married=true;
			}
			System.out.println("Do you have any Children? Y or N");
			String hasChildStr=sc.nextLine();
			if(hasChildStr.contentEquals("Y")){
				hasChild=true;
			}
			TermInsurance termInsurance=(TermInsurance) context.getBean("termInsurance");
			termInsurance.setInsurenceDetails(salaried,married,hasChild);
			customer=(Customer) context.getBean("customerWithTermInsurance");
			customer.setName(name);
			customer.setAge(age);
			System.out.println("Hi "+customer.getName()+
					" You have a "+customer.getInsurance().getInsuranceName()+
					"  Premium of "+customer.getInsurance().getInsurancePremium());
		}

	}
}
