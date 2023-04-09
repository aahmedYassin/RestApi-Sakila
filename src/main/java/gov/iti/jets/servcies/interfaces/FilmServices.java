package gov.iti.jets.servcies.interfaces;

import gov.iti.jets.Exceptions.InvalidDataException;
import java.util.ArrayList;

import gov.iti.jets.model.dtos.*;

public interface FilmServices {

    public FilmDto getFilmById(int id) throws InvalidDataException;

    public ArrayList<FilmDto> getAllFilms();

    public ArrayList<FilmDto> getFilmByLength( Short length) throws InvalidDataException;

    public CategoryDto getFilmCategoryById( int id) throws InvalidDataException;

    public ArrayList<ActorDto> geFilmActorsById( int id) throws InvalidDataException;

}
