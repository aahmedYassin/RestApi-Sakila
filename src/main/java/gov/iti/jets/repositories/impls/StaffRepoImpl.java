/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gov.iti.jets.repositories.impls;

import gov.iti.jets.model.entities.Country;
import gov.iti.jets.model.entities.Customer;
import gov.iti.jets.model.entities.Staff;
import gov.iti.jets.repositories.interfaces.StaffRepo;
import gov.iti.jets.utils.EntityManagerSingleton;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.util.NoSuchElementException;

/**
 *
 * @author Ahmed Yassin
 */
public class StaffRepoImpl implements StaffRepo {

    @Override
    public Staff getStaffById(int id) {
        try {
            return EntityManagerSingleton.getEntityManager().find(Staff.class, id);
        } catch (NoSuchElementException e) {

            return null;
        }
    }

    @Override
    public Staff getStaffByName(String name) {
        try {
            Query query = EntityManagerSingleton.getEntityManager()
                    .createQuery("select s from Staff s where s.firstName=:name");
            query.setParameter("name", name);
            return (Staff) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
