package com.example.EventRegistration;

public class StudentAttendee implements Attendee {
    /*
    1. Create the following attributes:
        a. name (String)
        b. batch (int)
        c. department (String)
    2. Make this class an implementation of Attendee interface and override the interface methods.
    */
    String name;
    int batch;
    String department;
    @Override
    public void setAttendeeDetails(String name, String department, int batch) {
        this.name=name;
        this.department=department;
        this.batch=batch;
    }

    @Override
    public void printRegistrationConfirmation() {
        System.out.println("Hi "+this.name+" your registration for the Graduation Ceremony is successful");
    }

    @Override
    public String getAttendeeName() {
        return this.name;
    }


}
