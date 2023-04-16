package gov.iti.jets.servcies.impls;

import gov.iti.jets.Exceptions.ErrorMessage;
import java.util.ArrayList;
import gov.iti.jets.repositories.impls.*;
import gov.iti.jets.servcies.interfaces.*;
import gov.iti.jets.model.dtos.*;
import gov.iti.jets.model.entities.*;
import gov.iti.jets.utils.mappers.*;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("city")
public class CityServicesImpl implements CityServices {

    @Override
    @GET
    @Path("getCityById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CityDto getCityById(@PathParam("id") int id) {
        CityRepoImpl cityRepoImpl = new CityRepoImpl();

        if (cityRepoImpl.getCityById(id) == null) {

            ErrorMessage errorMessage = new ErrorMessage("city id not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }

        return CityMapper.INSTANCE.toDto(cityRepoImpl.getCityById(id));

    }

    @Override
    @GET
    @Path("getCityByName/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public CityDto getCityByName(@PathParam("name") String name) {
        CityRepoImpl cityRepoImpl = new CityRepoImpl();

        if (cityRepoImpl.getCityByName(name) == null) {

            ErrorMessage errorMessage = new ErrorMessage("city name not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }

        return CityMapper.INSTANCE.toDto(cityRepoImpl.getCityByName(name));
    }

    @Override
    @GET
    @Path("getAllCities")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<CityDto> getAllCities() {
        CityRepoImpl cityRepoImpl = new CityRepoImpl();

        ArrayList<City> allCities = cityRepoImpl.getAllCities();
        ArrayList<CityDto> allCitiesDto = new ArrayList<>();
        for (int i = 0; i < allCities.size(); i++) {

            allCitiesDto.add(CityMapper.INSTANCE.toDto(allCities.get(i)));
        }

        return allCitiesDto;

    }

    @Override
    @GET
    @Path("getCityAddresses/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<AddressDto> getCityAddresses(@PathParam("id") int id) {
        CityRepoImpl cityRepoImpl = new CityRepoImpl();

        if (cityRepoImpl.getCityAddresses(id) == null) {

            ErrorMessage errorMessage = new ErrorMessage("city id not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }

        ArrayList<Address> address = cityRepoImpl.getCityAddresses(id);
        ArrayList<AddressDto> addressDto = new ArrayList<>();
        for (int i = 0; i < address.size(); i++) {

            addressDto.add(AddressMapper.INSTANCE.toDto(address.get(i)));
        }

        return addressDto;

    }

    @Override
    @GET
    @Path("getCityCountryById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CountryDto getCityCountryById(@PathParam("id") int id) {
        CityRepoImpl cityRepoImpl = new CityRepoImpl();

        if (cityRepoImpl.getCityCountryById(id) == null) {

            ErrorMessage errorMessage = new ErrorMessage("city id not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }

        return CountryMapper.INSTANCE.toDto(cityRepoImpl.getCityCountryById(id));

    }

}
