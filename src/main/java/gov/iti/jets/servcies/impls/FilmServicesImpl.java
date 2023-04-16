package gov.iti.jets.servcies.impls;

import gov.iti.jets.Exceptions.ErrorMessage;
import java.util.ArrayList;

import gov.iti.jets.repositories.impls.*;
import gov.iti.jets.model.dtos.*;
import gov.iti.jets.model.entities.*;
import gov.iti.jets.utils.mappers.*;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("film")
public class FilmServicesImpl {

    @GET
    @Path("getFilm/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilmById(@PathParam("id") int id) {
        FilmRepoImpl filmRepoImpl = new FilmRepoImpl();
        if (filmRepoImpl.getFilmById(id) == null) {

            ErrorMessage errorMessage = new ErrorMessage("film id not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }
        return Response.ok().entity(FilmMapper.INSTANCE.toDto(filmRepoImpl.getFilmById(id))).build();

    }

    @GET
    @Path("getAllFilms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFilms() {
        FilmRepoImpl filmRepoImpl = new FilmRepoImpl();
        ArrayList<Film> allFilms = filmRepoImpl.getAllFilms();
        ArrayList<FilmDto> allFilmsDto = new ArrayList<>();
        for (int i = 0; i < allFilms.size(); i++) {

            allFilmsDto.add(FilmMapper.INSTANCE.toDto(allFilms.get(i)));
        }

        return Response.ok().entity(allFilmsDto).build();

    }

    @GET
    @Path("getFilmByLength/{length}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilmByLength(@PathParam("length") Short length) {
        FilmRepoImpl filmRepoImpl = new FilmRepoImpl();
        if (filmRepoImpl.getFilmByLength(length) == null) {

            ErrorMessage errorMessage = new ErrorMessage("film length not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }
        ArrayList<Film> film = filmRepoImpl.getFilmByLength(length);
        ArrayList<FilmDto> filmDto = new ArrayList<>();
        for (int i = 0; i < film.size(); i++) {

            filmDto.add(FilmMapper.INSTANCE.toDto(film.get(i)));
        }

        return Response.ok().entity(filmDto).build();

    }

    @GET
    @Path("getFilmCategory/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilmCategoryById(@PathParam("id") int id) {

        FilmRepoImpl filmRepoImpl = new FilmRepoImpl();
        if (filmRepoImpl.getFilmCategoryById(id) == null) {

            ErrorMessage errorMessage = new ErrorMessage("film id not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }

        return Response.ok().entity(CategoryMapper.INSTANCE.toDto(filmRepoImpl.getFilmCategoryById(id))).build();

    }

    @GET
    @Path("geFilmActors/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response geFilmActorsById(@PathParam("id") int id) {
        FilmRepoImpl filmRepoImpl = new FilmRepoImpl();
        ArrayList<ActorDto> actorDto = new ArrayList<>();
        if (filmRepoImpl.geFilmActorsById(id) == null) {

            ErrorMessage errorMessage = new ErrorMessage("film id not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }
        for (int i = 0; i < filmRepoImpl.geFilmActorsById(id).size(); i++) {
            actorDto.add(ActorMapper.INSTANCE.toDto(filmRepoImpl.geFilmActorsById(id).get(i)));
        }

        return Response.ok().entity(actorDto).build();

    }

}
