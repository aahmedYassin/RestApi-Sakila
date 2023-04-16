package gov.iti.jets.servcies.interfaces;

import java.util.ArrayList;

import gov.iti.jets.model.dtos.*;

public interface CategoryServices {

    public CategoryDto getCategoryById(int id) ;

    public ArrayList<CategoryDto> getAllCategories();

    public ArrayList<FilmDto> getCategoryFilmsById(int id);

    public CategoryDto updateCategoryById(int id, String name);

    public int deleteCategoryById(int id);

    public CategoryDto createCategory(CategoryDto categoryDto);
}
