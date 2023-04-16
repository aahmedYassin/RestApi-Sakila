package gov.iti.jets.servcies.impls;

import gov.iti.jets.Exceptions.ErrorMessage;
import java.sql.Timestamp;
import java.util.ArrayList;

import gov.iti.jets.repositories.impls.*;
import gov.iti.jets.servcies.interfaces.*;
import gov.iti.jets.model.dtos.*;
import gov.iti.jets.model.entities.*;
import gov.iti.jets.utils.mappers.*;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("store")
public class StoreServicesImpl implements StoreServices {

    @Override
    @GET
    @Path("getStoreById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public StoreDto getStoreById(@PathParam("id") int id) {
        StoreRepoImpl storeRepoImpl = new StoreRepoImpl();

        if (storeRepoImpl.getStoreById(id) == null) {

            ErrorMessage errorMessage = new ErrorMessage("store id not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }

        return StoreMapper.INSTANCE.toDto(storeRepoImpl.getStoreById(id));
    }

    @Override
    @GET
    @Path("getStoreStaff/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<StaffDto> getStoreStaff(@PathParam("id") int id) {
        StoreRepoImpl storeRepoImpl = new StoreRepoImpl();

        if (storeRepoImpl.getStoreStaff(id) == null) {

            ErrorMessage errorMessage = new ErrorMessage("store id not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }

        ArrayList<Staff> staff = storeRepoImpl.getStoreStaff(id);
        ArrayList<StaffDto> staffDto = new ArrayList<>();
        for (int i = 0; i < staff.size(); i++) {
            staffDto.add(StaffMapper.INSTANCE.toDto(staff.get(i)));
        }

        return staffDto;

    }

    @Override
    @GET
    @Path("getStoreCustomer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<CustomerDto> getStoreCustomer(@PathParam("id") int id) {

        StoreRepoImpl storeRepoImpl = new StoreRepoImpl();

        if (storeRepoImpl.getStoreCustomer(id) == null) {

            ErrorMessage errorMessage = new ErrorMessage("store id not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }

        ArrayList<Customer> customer = storeRepoImpl.getStoreCustomer(id);
        ArrayList<CustomerDto> CustomerDto = new ArrayList<>();
        for (int i = 0; i < customer.size(); i++) {
            CustomerDto.add(CustomerMapper.INSTANCE.toDto(customer.get(i)));
        }

        return CustomerDto;

    }

}
