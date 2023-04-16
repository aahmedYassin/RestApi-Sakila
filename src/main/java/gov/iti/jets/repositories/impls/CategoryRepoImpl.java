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

public class CategoryRepoImpl implements CategoryRepo {

    public CategoryRepoImpl() {

    }

    @Override
    public Category getCategoryById(int id) {
        try {
            return EntityManagerSingleton.getEntityManager().find(Category.class, id);
        } catch (NoSuchElementException e) {

            return null;
        }
    }

    @Override
    public ArrayList<Category> getAllCategories() {
        try {
            Query query = EntityManagerSingleton.getEntityManager().createQuery("select c from Category c");
            return (ArrayList<Category>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public ArrayList<Film> getCategoryFilmsById(int id) {

        Category category = getCategoryById(id);
        if (category == null) {
            return null;

        }
        Set<FilmCategory> filmCategorys = category.getFilmCategories();
        List<FilmCategory> filmCategoryList = new ArrayList<>(filmCategorys);
        ArrayList<Film> films = new ArrayList<>();

        for (int i = 0; i < filmCategoryList.size(); i++) {
            films.add(filmCategoryList.get(i).getFilm());
        }

        return films;
    }

    @Override
    public Category updateCategoryById(int id, String name) {
        Category category = getCategoryById(id);
        if (category == null) {
            return null;
        }
        EntityTransaction entityTransaction = EntityManagerSingleton.getEntityManager().getTransaction();
        entityTransaction.begin();
        category.setName(name);
        entityTransaction.commit();

        return category;
    }

    @Override
    public int deleteCategoryById(int id) {
        Category category = getCategoryById(id);
        if (category == null) {
            return -1;
        }
        EntityTransaction entityTransaction = EntityManagerSingleton.getEntityManager().getTransaction();
        entityTransaction.begin();
        EntityManagerSingleton.getEntityManager().remove(category);
        entityTransaction.commit();
        return 1;
    }

    @Override
    public Category createCategory(Category category) {
        EntityTransaction entityTransaction = EntityManagerSingleton.getEntityManager().getTransaction();
        entityTransaction.begin();
        EntityManagerSingleton.getEntityManager().persist(category);
        entityTransaction.commit();
        return category;

    }

}
