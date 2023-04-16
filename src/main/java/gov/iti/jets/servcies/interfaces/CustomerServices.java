package gov.iti.jets.servcies.interfaces;

import java.util.ArrayList;

import gov.iti.jets.model.dtos.*;
import gov.iti.jets.model.entities.*;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

public interface CustomerServices {

    public CustomerDto getCustomerById(int id) ;

    public CustomerDto getCustomerByName(String name);

}
