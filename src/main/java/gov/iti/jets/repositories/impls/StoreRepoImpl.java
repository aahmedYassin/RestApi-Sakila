/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gov.iti.jets.repositories.impls;

import gov.iti.jets.model.dtos.StoreDto;
import gov.iti.jets.model.entities.Country;
import gov.iti.jets.model.entities.Customer;
import gov.iti.jets.model.entities.Film;
import gov.iti.jets.model.entities.FilmActor;
import gov.iti.jets.model.entities.Staff;
import gov.iti.jets.model.entities.Store;
import gov.iti.jets.repositories.interfaces.StoreRepo;
import gov.iti.jets.utils.EntityManagerSingleton;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 *
 * @author Ahmed Yassin
 */
public class StoreRepoImpl implements StoreRepo {

    @Override
    public Store getStoreById(int id) {
        try {
            return EntityManagerSingleton.getEntityManager().find(Store.class, id);
        } catch (NoSuchElementException e) {

            return null;
        }
    }

    @Override
    public ArrayList<Staff> getStoreStaff(int id)  {

        Store store = getStoreById(id);
        if (store == null) {
            return null;
        }

        Set<Staff> staff = store.getStaffs();

        List<Staff> allStaffs = new ArrayList<>(staff);
        ArrayList<Staff> staffList = new ArrayList<>();
        for (int i = 0; i < allStaffs.size(); i++) {
            staffList.add(allStaffs.get(i));
        }
        return staffList;

    }

    @Override
    public ArrayList<Customer> getStoreCustomer(int id)  {

        Store store = getStoreById(id);
        if (store == null) {
            return null;
        }

        Set<Customer> customer = store.getCustomers();

        List<Customer> allCustomers = new ArrayList<>(customer);
        ArrayList<Customer> customersList = new ArrayList<>();
        for (int i = 0; i < allCustomers.size(); i++) {
            customersList.add(allCustomers.get(i));
        }
        return customersList;

    }

}
