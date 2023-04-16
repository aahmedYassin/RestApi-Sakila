package gov.iti.jets.servcies.impls;

import java.sql.Timestamp;
import java.util.ArrayList;

import gov.iti.jets.Exceptions.*;
import gov.iti.jets.repositories.impls.ActorRepoImpl;
import gov.iti.jets.model.dtos.*;
import gov.iti.jets.model.entities.*;
import gov.iti.jets.utils.mappers.*;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.util.Arrays;

@Path("actor")
public class ActorServicesImpl {

    @GET
    @Path("getActor/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActorById(@PathParam("id") int id, @Context UriInfo uriInfo)  {
        ActorRepoImpl actorRepoImpl = new ActorRepoImpl();

        if (actorRepoImpl.getActorById(id) == null) {

            ErrorMessage errorMessage = new ErrorMessage("wrong actor id");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);

        }

        ActorDto actorDto = ActorMapper.INSTANCE.toDto(actorRepoImpl.getActorById(id));
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        actorDto.setLinks(Arrays.asList(self));
        return Response.ok(actorDto).build();

    }

    @GET
    @Path("getAllActors")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllActors() {
        ActorRepoImpl actorRepoImpl = new ActorRepoImpl();
        ArrayList<Actor> allActors = actorRepoImpl.getAllActors();
        ArrayList<ActorDto> allActorsDto = new ArrayList<>();
        for (int i = 0; i < allActors.size(); i++) {

            allActorsDto.add(ActorMapper.INSTANCE.toDto(allActors.get(i)));
        }

        return Response.ok().entity(allActorsDto).build();

    }

    @GET
    @Path("getActorByName/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActorByFirstName(@PathParam("name") String name, @Context UriInfo uriInfo) {
        ActorRepoImpl actorRepoImpl = new ActorRepoImpl();
        if (actorRepoImpl.getActorByFirstName(name) == null) {

            ErrorMessage errorMessage = new ErrorMessage("wrong first name");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }

        ActorDto actorDto = ActorMapper.INSTANCE.toDto(actorRepoImpl.getActorByFirstName(name));
        return Response.ok(actorDto).build();
    }

    @POST
    @Path("createActor")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createActor(ActorDto actorDto, @Context UriInfo uriInfo) {
        ActorRepoImpl actorRepoImpl = new ActorRepoImpl();
        actorDto.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        actorRepoImpl.createActor(ActorMapper.INSTANCE.toEntity(actorDto));
        return Response.ok().entity(actorDto).build();

    }

    @GET
    @Path("updateActor")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateActorById(@QueryParam("id") int id, @QueryParam("firstName") String firstName) {
        ActorRepoImpl actorRepoImpl = new ActorRepoImpl();
        if (actorRepoImpl.updateActorById(id, firstName) == null) {

            ErrorMessage errorMessage = new ErrorMessage("wrong actor id");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }

        return Response.ok().entity(ActorMapper.INSTANCE.toDto(actorRepoImpl.updateActorById(id, firstName))).build();

    }

    @DELETE
    @Path("deleteActor/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public int deleteActorById(@PathParam("id") int id)  {
        ActorRepoImpl actorRepoImpl = new ActorRepoImpl();

        return actorRepoImpl.deleteActorById(id);

    }

    @GET
    @Path("getActorFilms/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActorFilmsById(@PathParam("id") int id) {

        ActorRepoImpl actorRepoImpl = new ActorRepoImpl();
        if (actorRepoImpl.getActorFilmsById(id) == null) {

            ErrorMessage errorMessage = new ErrorMessage("wrong actor id");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }
        ArrayList<Film> film = actorRepoImpl.getActorFilmsById(id);
        ArrayList<FilmDto> filmDto = new ArrayList<>();
        for (int i = 0; i < film.size(); i++) {
            filmDto.add(FilmMapper.INSTANCE.toDto(film.get(i)));
        }

        return Response.ok().entity(filmDto).build();

    }

}
