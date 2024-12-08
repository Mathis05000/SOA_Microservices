package fr.insa.soa.RestProject.controller;

import java.util.ArrayList;
import java.util.List;

import fr.insa.soa.RestProject.entity.Volunteer;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("volunteer")
public class VolunteerResource {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Volunteer> getVolunteers() {
		
		Volunteer volunteer1 = new Volunteer("Antoine", "Dupond");
		Volunteer volunteer2 = new Volunteer("Léon", "Marchand");
		ArrayList<Volunteer> listVolunteer = new ArrayList<Volunteer>();
		listVolunteer.add(volunteer1);
		listVolunteer.add(volunteer2);
        return listVolunteer;
    }
	
	@GET
	@Path("/{lastNameVolunteer}")
    public Response getVolunteerByLastName(@PathParam("lastNameVolunteer") String lastName) {
		
		Volunteer volunteer1 = new Volunteer("Antoine", "Dupond");
		Volunteer volunteer2 = new Volunteer("Léon", "Marchand");
		ArrayList<Volunteer> listVolunteer = new ArrayList<Volunteer>();
		listVolunteer.add(volunteer1);
		listVolunteer.add(volunteer2);
		
		Volunteer volunteerFind = null;
		
		for(Volunteer volunteer : listVolunteer) {
			if (volunteer.getLastName().equals(lastName)) {
				volunteerFind = volunteer;
			}
		}
		
		if (volunteerFind != null) {
			return Response.ok(volunteerFind).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("Volunteer not found").build();
		}	
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Volunteer addVolunteer(Volunteer volunteer) {
		// add volunteer to database
		return volunteer;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Volunteer modifiedVolunteer(Volunteer volunteer) {
		// modified volunteer in the database
		return volunteer;
	}
}