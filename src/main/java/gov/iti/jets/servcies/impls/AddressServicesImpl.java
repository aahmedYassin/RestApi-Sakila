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

@Path("address")
public class AddressServicesImpl implements AddressServices {

    @Override
    @GET
    @Path("getAddressById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AddressDto getAddressById(@PathParam("id") int id) {
        AddressRepoImpl addressRepoImpl = new AddressRepoImpl();

        if (addressRepoImpl.getAddressById(id) == null) {

            ErrorMessage errorMessage = new ErrorMessage("address id not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }

        return AddressMapper.INSTANCE.toDto(addressRepoImpl.getAddressById(id));

    }

    @Override
    @GET
    @Path("getAddressByPostalCode/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<AddressDto> getAddressByPostalCode(@PathParam("code") String code) {
        AddressRepoImpl addressRepoImpl = new AddressRepoImpl();

        if (addressRepoImpl.getAddressByPostalCode(code) == null || addressRepoImpl.getAddressByPostalCode(code).size() == 0) {

            ErrorMessage errorMessage = new ErrorMessage("postal code not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }

        ArrayList<AddressDto> addressDtos = new ArrayList<>();

        for (int i = 0; i < addressRepoImpl.getAddressByPostalCode(code).size(); i++) {
            addressDtos.add(AddressMapper.INSTANCE.toDto(addressRepoImpl.getAddressByPostalCode(code).get(i)));
        }
        return addressDtos;

    }

    @Override
    @GET
    @Path("getAddressByDistrict/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<AddressDto> getAddressByDistrict(@PathParam("name") String name) {
        AddressRepoImpl addressRepoImpl = new AddressRepoImpl();

        if (addressRepoImpl.getAddressByDistrict(name) == null || addressRepoImpl.getAddressByDistrict(name).size() == 0) {

            ErrorMessage errorMessage = new ErrorMessage("distract name not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }
        ArrayList<AddressDto> addressDtos = new ArrayList<>();

        for (int i = 0; i < addressRepoImpl.getAddressByDistrict(name).size(); i++) {
            addressDtos.add(AddressMapper.INSTANCE.toDto(addressRepoImpl.getAddressByDistrict(name).get(i)));
        }
        return addressDtos;
    }

}
