package gov.iti.jets.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.model.entities.*;

public interface FilmRepo {

    public Film getFilmById(int id);

    public ArrayList<Film> getAllFilms();

    public ArrayList<Film> getFilmByLength(Short length);

    public Category getFilmCategoryById(int id);

    public ArrayList<Actor> geFilmActorsById(int id);

}
