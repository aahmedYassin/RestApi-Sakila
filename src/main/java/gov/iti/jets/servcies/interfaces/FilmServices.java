package gov.iti.jets.servcies.interfaces;

import java.util.ArrayList;

import gov.iti.jets.model.dtos.*;

public interface FilmServices {

    public FilmDto getFilmById(int id);

    public ArrayList<FilmDto> getAllFilms();

    public ArrayList<FilmDto> getFilmByLength( Short length) ;

    public CategoryDto getFilmCategoryById( int id) ;

    public ArrayList<ActorDto> geFilmActorsById( int id) ;

}
