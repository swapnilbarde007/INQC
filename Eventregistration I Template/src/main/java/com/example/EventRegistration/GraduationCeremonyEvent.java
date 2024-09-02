package com.example.EventRegistration;


import java.util.ArrayList;
import java.util.List;

public class GraduationCeremonyEvent implements CollegeEvent{
    String name="Graduation Ceremony";
    String address="Auditorium";
    String time="10AM";
    String date="12 Nov 2023";
    int count=0;
    Attendee attendee;
    List<Attendee> eventAttendees=new ArrayList<>();

    @Override
    public void registerStudent(Attendee user) {
        count++;
        eventAttendees.add(user);
    }

    @Override
    public List<Attendee> getAllAttendees() {
        return this.eventAttendees;
    }

    @Override
    public void printEventDetails() {
        System.out.println("The Graduation Ceremony details are as follows:");
        System.out.println("Venue: Auditorium");
        System.out.println("Time: 10AM");
        System.out.println("Date: 12 Nov 2023");
    }

    @Override
    public int getAttendeeCount() {
        return eventAttendees.size();
    }

    public void setAttendee(Attendee attendee) {
        this.attendee = attendee;
    }

    public Attendee getAttendee() {
        return attendee;
    }
    /*
    1. Create the following attributes:
        a. name (initialize it as "Graduation Ceremony".
        b. address (String)
        c. time (String)
        d. date (String)
        e. count (int) (initially 0)
        f. eventAttendees (List of Attendee)
        NOTE: Initialize the address, time and date attributes with some values.
    2. Inject Attendee with attribute name "attendee" with setter injection.
    3. Make this class an implementation of CollegeEvent interface and override the interface methods.
    */

}
