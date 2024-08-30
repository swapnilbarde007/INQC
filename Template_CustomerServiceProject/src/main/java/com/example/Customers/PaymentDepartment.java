package com.example.Customers;

import java.util.Scanner;

/*
     This class is an implementation of a CustomerCare Interface based on the selection 
     in the console the department type is selected.You need to complete this class 
     based on the following tasks.

     Tasks:
       1. Override the methods of CustomerCare Interface:
       2. Build your logic for all the method based on the description given in CustomerCare Interface.
 */
public class PaymentDepartment implements CustomerCare {

  private String department = "Payment Department";
  private String customerName;
  private String issue;
  private double refId;

  @Override
  public String getDepartment() {
    return this.department;
  }

  @Override
  public void getService() {
    System.out.println("Welcome to " + getDepartment() + " " + customerName);
    System.out.println("How may I assist you with you payment inquiry?");
    Scanner sc = new Scanner(System.in);
    issue = sc.nextLine();
    getProblem();
    sc.close();
  }

  @Override
  public void setCustomerName(String name) {
    this.customerName = name;
  }

  @Override
  public void setProblem(String problem) {
    this.issue = problem;
  }

  @Override
  public void getProblem() {
    refId = 751.0d;
    System.out.println(
        "Dear " + customerName + " your issue for " + issue + " has been recorded, your reference id is: " + refId);
  }

}