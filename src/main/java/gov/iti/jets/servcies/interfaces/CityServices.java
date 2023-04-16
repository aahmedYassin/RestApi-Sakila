package gov.iti.jets.servcies.interfaces;

import java.util.ArrayList;

import gov.iti.jets.model.dtos.*;
import gov.iti.jets.model.entities.*;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

public interface CityServices {

    public CityDto getCityById(int id);

    public CityDto getCityByName(String name);

    public ArrayList<CityDto> getAllCities();

    public ArrayList<AddressDto> getCityAddresses(int id) ;

    public CountryDto getCityCountryById(int id) ;

}
