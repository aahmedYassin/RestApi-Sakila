package gov.iti.jets.repositories.interfaces;

import gov.iti.jets.model.dtos.FilmDto;
import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.model.entities.*;

public interface CategoryRepo {

    public Category getCategoryById(int id);

    public ArrayList<Category> getAllCategories();
    
    public ArrayList<Film> getCategoryFilmsById(int id);

}
