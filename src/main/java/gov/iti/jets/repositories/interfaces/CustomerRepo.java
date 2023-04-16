package gov.iti.jets.repositories.interfaces;

import gov.iti.jets.model.dtos.CustomerDto;
import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.model.entities.*;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

public interface CustomerRepo {

    
    public Customer getCustomerById( int id) ;


    public Customer getCustomerByName( String name) ;


}
