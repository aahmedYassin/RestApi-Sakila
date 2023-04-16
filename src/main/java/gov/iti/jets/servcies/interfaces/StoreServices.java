package gov.iti.jets.servcies.interfaces;

import java.util.ArrayList;

import gov.iti.jets.model.dtos.*;
import gov.iti.jets.model.entities.*;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

public interface StoreServices {

    public StoreDto getStoreById(int id) ;

    public ArrayList<StaffDto> getStoreStaff(int id) ;

    public ArrayList<CustomerDto> getStoreCustomer(int id) ;

}
