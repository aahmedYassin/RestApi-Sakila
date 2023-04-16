package gov.iti.jets.repositories.interfaces;

import gov.iti.jets.model.dtos.CityDto;
import gov.iti.jets.model.dtos.CustomerDto;
import gov.iti.jets.model.dtos.StaffDto;
import gov.iti.jets.model.dtos.StoreDto;
import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.model.entities.*;
import jakarta.jws.WebParam;

public interface StoreRepo {

    public Store getStoreById(int id);

    public ArrayList<Staff> getStoreStaff(int id) ;

    public ArrayList<Customer> getStoreCustomer(int id) ;

}
