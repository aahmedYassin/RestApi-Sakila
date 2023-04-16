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

@Path("customer")
public class CustomerServicesImpl implements CustomerServices {

    @Override
    @GET
    @Path("getCustomerById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerDto getCustomerById(@PathParam("id") int id) {
        CustomerRepoImpl customerRepoImpl = new CustomerRepoImpl();

        if (customerRepoImpl.getCustomerById(id) == null) {

            ErrorMessage errorMessage = new ErrorMessage("customer id not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }

        return CustomerMapper.INSTANCE.toDto(customerRepoImpl.getCustomerById(id));

    }

    @Override
    @GET
    @Path("getCustomerByName/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerDto getCustomerByName(@PathParam("name") String name) {

        CustomerRepoImpl customerRepoImpl = new CustomerRepoImpl();

        if (customerRepoImpl.getCustomerByName(name) == null) {

            ErrorMessage errorMessage = new ErrorMessage("customer name not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }

        return CustomerMapper.INSTANCE.toDto(customerRepoImpl.getCustomerByName(name));
    }

}
