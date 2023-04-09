package gov.iti.jets.servcies.interfaces;

import java.util.ArrayList;

import gov.iti.jets.Exceptions.*;
import gov.iti.jets.model.dtos.*;


public interface ActorServices {

    public ActorDto getActorById(int id) throws InvalidDataException;

    public ArrayList<ActorDto> getAllActors();

    public ActorDto getActorByFirstName(String name) throws InvalidDataException;

    public ActorDto createActor(ActorDto actorDto);

    public ActorDto updateActorById(int id,String firstName) throws InvalidDataException;

    public int deleteActorById(int id) throws InvalidDataException;

    public ArrayList<FilmDto> getActorFilmsById(int id) throws InvalidDataException;

}
