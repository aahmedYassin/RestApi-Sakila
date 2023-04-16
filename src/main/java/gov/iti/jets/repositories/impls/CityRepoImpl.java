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

public class CityRepoImpl implements CityRepo {

    public CityRepoImpl() {

    }

    @Override
    public City getCityById(int id) {
        try {
            return EntityManagerSingleton.getEntityManager().find(City.class, id);
        } catch (NoSuchElementException e) {

            return null;
        }
    }

    @Override
    public City getCityByName(String name) {
        try {
            Query query = EntityManagerSingleton.getEntityManager()
                    .createQuery("select c from City c where c.city=:city");
            query.setParameter("city", name);
            return (City) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public ArrayList<City> getAllCities() {
        Query query = EntityManagerSingleton.getEntityManager().createQuery("select c from City c");
        return (ArrayList<City>) query.getResultList();
    }

    @Override
    public ArrayList<Address> getCityAddresses(int id) {

        City city = getCityById(id);
        if (city == null) {

            return null;
        }

        Set<Address> address = city.getAddresses();
        List<Address> addressList = new ArrayList<>(address);
        ArrayList<Address> cityAddress = new ArrayList<>();
        for (int i = 0; i < addressList.size(); i++) {
            cityAddress.add(addressList.get(i));
        }
        return cityAddress;

    }

    @Override
    public Country getCityCountryById(int id) {

        City city = getCityById(id);
        if (city == null) {

            return null;
        }

        return city.getCountry();

    }

}
