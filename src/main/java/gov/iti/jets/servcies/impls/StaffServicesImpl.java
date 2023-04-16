package gov.iti.jets.servcies.impls;

import gov.iti.jets.Exceptions.ErrorMessage;
import gov.iti.jets.repositories.impls.*;
import gov.iti.jets.servcies.interfaces.*;
import gov.iti.jets.model.dtos.*;
import gov.iti.jets.utils.mappers.*;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("staff")
public class StaffServicesImpl implements StaffServices {

    @Override
    @GET
    @Path("getStaffById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public StaffDto getStaffById(@PathParam("id") int id) {
        StaffRepoImpl staffRepoImpl = new StaffRepoImpl();

        if (staffRepoImpl.getStaffById(id) == null) {

            ErrorMessage errorMessage = new ErrorMessage("staff id not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }

        return StaffMapper.INSTANCE.toDto(staffRepoImpl.getStaffById(id));
    }

    @Override
    @GET
    @Path("getStaffByName/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public StaffDto getStaffByName(@PathParam("name") String name) {
        StaffRepoImpl staffRepoImpl = new StaffRepoImpl();

        if (staffRepoImpl.getStaffByName(name) == null) {

            ErrorMessage errorMessage = new ErrorMessage("staff name not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }

        return StaffMapper.INSTANCE.toDto(staffRepoImpl.getStaffByName(name));

    }

}
