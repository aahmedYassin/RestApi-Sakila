package gov.iti.jets.servcies.interfaces;

import gov.iti.jets.Exceptions.InvalidDataException;
import java.util.ArrayList;

import gov.iti.jets.model.dtos.*;


public interface CategoryServices {

    public CategoryDto getCategoryById(int id) throws InvalidDataException;

    public ArrayList<CategoryDto> getAllCategories();

    public ArrayList<FilmDto> getCategoryFilmsById(int id) throws InvalidDataException;

}
