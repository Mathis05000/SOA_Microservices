package Controller;

import Repository.HelpedUser;
import Repository.Validator;
import Repository.Volunteer;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName="CreateUser")
public class CreateUser {

    @WebMethod(operationName="CreateVolunteer")
    public Volunteer CreateVolunteer(String firstName, String lastName) {
        return new Volunteer(firstName, lastName);
    }

    @WebMethod(operationName="CreateHelpedUser")
    public HelpedUser CreateHelpedUser(String firstName, String lastName) {
        return new HelpedUser(firstName, lastName);
    }

    @WebMethod(operationName="CreateValidator")
    public Validator CreateValidator(String firstName, String lastName) {
        return new Validator(firstName, lastName);
    }
}