/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gov.iti.jets.repositories.impls;

import gov.iti.jets.model.entities.Actor;
import gov.iti.jets.model.entities.Country;
import gov.iti.jets.model.entities.Customer;
import gov.iti.jets.repositories.interfaces.CustomerRepo;
import gov.iti.jets.utils.EntityManagerSingleton;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.util.NoSuchElementException;

/**
 *
 * @author Ahmed Yassin
 */
public class CustomerRepoImpl implements CustomerRepo {

    @Override
    public Customer getCustomerById(int id) {
        try {
            return EntityManagerSingleton.getEntityManager().find(Customer.class, id);
        } catch (NoSuchElementException e) {

            return null;
        }
    }

    @Override
    public Customer getCustomerByName(String name) {
        try {
            Query query = EntityManagerSingleton.getEntityManager()
                    .createQuery("select c from Customer c where c.firstName=:name");
            query.setParameter("name", name);
            return (Customer) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
