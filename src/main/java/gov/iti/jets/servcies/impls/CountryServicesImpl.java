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

@Path("country")
public class CountryServicesImpl implements CountryServices {

    @Override
    @GET
    @Path("getCountry/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CountryDto getCountryById(@PathParam("id") int id) {
        CountryRepoImpl countryRepoImpl = new CountryRepoImpl();

        if (countryRepoImpl.getCountryById(id) == null) {
            ErrorMessage errorMessage = new ErrorMessage("country id not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }

        return CountryMapper.INSTANCE.toDto(countryRepoImpl.getCountryById(id));

    }

    @Override
    @GET
    @Path("getCountryCities/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<CityDto> getCountryCities(@PathParam("id") int id) {
        CountryRepoImpl countryRepoImpl = new CountryRepoImpl();

        if (countryRepoImpl.getCountryById(id) == null) {

            ErrorMessage errorMessage = new ErrorMessage("country id not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }

        ArrayList<City> allCities = countryRepoImpl.getCountryCities(id);

        ArrayList<CityDto> allCitiesDto = new ArrayList<>();
        for (int i = 0; i < allCities.size(); i++) {

            allCitiesDto.add(CityMapper.INSTANCE.toDto(allCities.get(i)));
        }

        return allCitiesDto;

    }

}
