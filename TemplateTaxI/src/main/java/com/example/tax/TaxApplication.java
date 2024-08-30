package com.example.tax;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class TaxApplication {

	public static void main(String[] args) {
		// Take ClassPathXmlApplicationContext from applicationContext.xml file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("Which Tax would you like to pay? (Type: property/income)");
		Scanner sc = new Scanner(System.in);
		String taxChoice = sc.nextLine();
		if (taxChoice.equals("property")) {
			Tax propertyTax = (Tax) context.getBean("propertyTax");
			System.out.println("Enter taxable amount: ");
			int taxableAmount = sc.nextInt();
			propertyTaxExecutor(propertyTax, taxableAmount);
		} else if (taxChoice.equals("income")) {
			Tax incomeTax = (Tax) context.getBean("incomeTax");
			System.out.println("Enter taxable amount: ");
			int taxableAmount = sc.nextInt();
			incomeTaxExecutor(incomeTax, taxableAmount);
		} else {
			System.out.println("Invalid choice");
		}

	}

	public static void propertyTaxExecutor(Tax propertyTax, int taxableAmount) {
		if (!propertyTax.isTaxPayed()) {
			propertyTax.setTaxableAmount(taxableAmount);
			propertyTax.calculateTaxAmount();
			System.out.println("Your Tax Amount is : " + propertyTax.getTaxAmount());
			taxPayment(propertyTax);
		} else {
			System.out.println("You have already paid the Property Tax");
		}
	}

	public static void incomeTaxExecutor(Tax incomeTax, int taxableAmount) {
		if (!incomeTax.isTaxPayed()) {
			incomeTax.setTaxableAmount(taxableAmount);
			incomeTax.calculateTaxAmount();
			System.out.println("Your Tax Amount is : " + incomeTax.getTaxAmount());
			taxPayment(incomeTax);
		} else {
			System.out.println("You have already paid the Income Tax");
		}
	}

	public static void taxPayment(Tax taxObj) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you wish to pay the tax amount? (Y/N)");
		String choice = sc.next();
		if (choice.equals("Y")) {
			taxObj.payTax();
		}

	}

}
