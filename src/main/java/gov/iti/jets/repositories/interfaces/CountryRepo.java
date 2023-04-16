package gov.iti.jets.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.model.entities.*;

public interface CountryRepo {

    public Country getCountryById(int id);

    public ArrayList<City> getCountryCities(int id);

}
