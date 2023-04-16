package gov.iti.jets.repositories.impls;

import java.util.ArrayList;

import gov.iti.jets.repositories.interfaces.*;
import gov.iti.jets.model.entities.*;
import gov.iti.jets.utils.EntityManagerSingleton;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.util.*;
import gov.iti.jets.model.entities.*;

public class CountryRepoImpl implements CountryRepo {

    public CountryRepoImpl() {

    }

    @Override
    public Country getCountryById(int id) {
        try {
            return EntityManagerSingleton.getEntityManager().find(Country.class, id);
        } catch (NoSuchElementException e) {

            return null;
        }
    }

    @Override
    public ArrayList<City> getCountryCities(int id) {
        
        Country country=getCountryById(id);
           if (country == null) {

            return null;
        }
        Set<City>countries=country.getCities();
        
        List<City> countriesCity = new ArrayList<>(countries);
    
        return (ArrayList<City>) countriesCity;
        
    }


}
