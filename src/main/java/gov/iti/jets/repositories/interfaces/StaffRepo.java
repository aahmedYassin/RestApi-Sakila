package gov.iti.jets.repositories.interfaces;

import gov.iti.jets.model.dtos.StaffDto;
import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.model.entities.*;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

public interface StaffRepo {

    public Staff getStaffById(int id);

    public Staff getStaffByName(String name);

}
