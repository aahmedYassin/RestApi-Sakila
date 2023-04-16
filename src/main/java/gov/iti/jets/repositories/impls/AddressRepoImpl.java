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

public class AddressRepoImpl implements AddressRepo {

    public AddressRepoImpl() {

    }

    @Override
    public Address getAddressById(int id) {
        try {
            return EntityManagerSingleton.getEntityManager().find(Address.class, id);
        } catch (NoSuchElementException e) {

            return null;
        }
    }

    @Override
    public ArrayList<Address> getAddressByPostalCode(String postalCode) {

        try {
            Query query = EntityManagerSingleton.getEntityManager()
                    .createQuery("select a from Address a where a.postalCode=:postalCode");
            query.setParameter("postalCode", postalCode);
            return (ArrayList<Address>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public ArrayList<Address> getAddressByDistrict(String name) {

        try {
            Query query = EntityManagerSingleton.getEntityManager()
                    .createQuery("select a from Address a where a.district=:district");
            query.setParameter("district", name);
            return (ArrayList<Address>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }

    }

}
