package gov.iti.jets.repositories.impls;

import java.util.ArrayList;

import gov.iti.jets.repositories.interfaces.ActorRepo;
import gov.iti.jets.model.entities.Actor;
import gov.iti.jets.utils.EntityManagerSingleton;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.util.*;
import gov.iti.jets.model.entities.*;

public class ActorRepoImpl implements ActorRepo {

    public ActorRepoImpl() {

    }

    @Override
    public Actor getActorById(int id) {
        try {
            return EntityManagerSingleton.getEntityManager().find(Actor.class, id);
        } catch (NoSuchElementException e) {

            return null;
        }

    }

    @Override
    public ArrayList<Actor> getAllActors() {
        Query query = EntityManagerSingleton.getEntityManager().createQuery("select a from Actor a");
        return (ArrayList<Actor>) query.getResultList();

    }

    @Override
    public Actor getActorByFirstName(String firstName) {
        try {
            Query query = EntityManagerSingleton.getEntityManager()
                    .createQuery("select a from Actor a where a.firstName=:firstName");
            query.setParameter("firstName", firstName);
            return (Actor) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Actor createActor(Actor actor) {

        EntityTransaction entityTransaction = EntityManagerSingleton.getEntityManager().getTransaction();
        entityTransaction.begin();
        EntityManagerSingleton.getEntityManager().persist(actor);
        entityTransaction.commit();
        return actor;
    }

    @Override
    public Actor updateActorById(int id, String firstName) {
        Actor actor = getActorById(id);
        if (actor == null) {
            return null;
        }
        EntityTransaction entityTransaction = EntityManagerSingleton.getEntityManager().getTransaction();
        entityTransaction.begin();
        actor.setFirstName(firstName);
        entityTransaction.commit();

        return actor;

    }

    @Override
    public int deleteActorById(int id) {
        Actor actor = getActorById(id);
        if (actor == null) {
            return -1;
        }
        EntityTransaction entityTransaction = EntityManagerSingleton.getEntityManager().getTransaction();
        entityTransaction.begin();
        EntityManagerSingleton.getEntityManager().remove(actor);
        entityTransaction.commit();
        return 1;
    }

    @Override
    public ArrayList<Film> getActorFilmsById(int id) {
        Actor actor = getActorById(id);
        if (actor == null) {

            return null;
        }

        Set<FilmActor> filmActor = actor.getFilmActors();
        List<FilmActor> filmActorList = new ArrayList<>(filmActor);
        ArrayList<Film> film = new ArrayList<>();
        for (int i = 0; i < filmActorList.size(); i++) {
            film.add(filmActorList.get(i).getFilm());
        }
        return film;

    }

}
