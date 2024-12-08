package Repository;

public class Volunteer extends User {

    public Volunteer(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Volunteer CreateVolunteer(String firstName, String lastName) {
        return new Volunteer(firstName, lastName);
    }
}