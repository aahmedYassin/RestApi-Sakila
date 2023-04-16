package gov.iti.jets.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.model.entities.*;

public interface CityRepo {

    public City getCityById(int id);

    public City getCityByName(String name);

    public ArrayList<City> getAllCities();

    public ArrayList<Address> getCityAddresses(int id);

    public Country getCityCountryById(int id);

}
