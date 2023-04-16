package gov.iti.jets.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.model.entities.*;

public interface AddressRepo {

    public Address getAddressById(int id) ;

    public ArrayList<Address> getAddressByPostalCode(String postalCode);

    public ArrayList<Address> getAddressByDistrict(String name);

}
