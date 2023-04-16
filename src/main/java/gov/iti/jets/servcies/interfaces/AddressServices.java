package gov.iti.jets.servcies.interfaces;

import java.util.ArrayList;

import gov.iti.jets.model.dtos.*;
import gov.iti.jets.model.entities.*;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;


public interface AddressServices {

    public AddressDto getAddressById( int id);

    public ArrayList<AddressDto> getAddressByPostalCode( String code);

    public ArrayList<AddressDto> getAddressByDistrict( String name) ;
}
