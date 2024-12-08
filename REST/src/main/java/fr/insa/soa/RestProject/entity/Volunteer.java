package fr.insa.soa.RestProject.entity;

public class Volunteer extends User {
	
	// Default constructor
    public Volunteer() {
    }

    public Volunteer(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Volunteer CreateVolunteer(String firstName, String lastName) {
        return new Volunteer(firstName, lastName);
    }
}