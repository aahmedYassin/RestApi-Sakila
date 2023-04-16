package gov.iti.jets.servcies.interfaces;

import java.util.ArrayList;

import gov.iti.jets.Exceptions.*;
import gov.iti.jets.model.dtos.*;


public interface ActorServices {

    public ActorDto getActorById(int id) ;

    public ArrayList<ActorDto> getAllActors();

    public ActorDto getActorByFirstName(String name) ;

    public ActorDto createActor(ActorDto actorDto);

    public ActorDto updateActorById(int id,String firstName);

    public int deleteActorById(int id);

    public ArrayList<FilmDto> getActorFilmsById(int id) ;

}
