package gov.iti.jets.servcies.interfaces;

import java.util.ArrayList;

import gov.iti.jets.model.dtos.*;
import gov.iti.jets.model.entities.*;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

public interface CountryServices {

    public CountryDto getCountryById(int id) ;

    public ArrayList<CityDto> getCountryCities(int id);

}
