package gov.iti.jets.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.model.entities.*;

public interface ActorRepo {

    public Actor getActorById(int id);

    public ArrayList<Actor> getAllActors();

    public Actor getActorByFirstName(String firstName);

    public Actor createActor(Actor actor);

    public Actor updateActorById(int id, String firstName);

    public int deleteActorById(int id);

    public ArrayList<Film> getActorFilmsById(int id);

}
