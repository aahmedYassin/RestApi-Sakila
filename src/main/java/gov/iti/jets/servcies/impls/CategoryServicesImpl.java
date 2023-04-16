package gov.iti.jets.servcies.impls;

import gov.iti.jets.Exceptions.ErrorMessage;
import java.util.ArrayList;

import gov.iti.jets.repositories.impls.*;
import gov.iti.jets.servcies.interfaces.*;
import gov.iti.jets.model.dtos.*;
import gov.iti.jets.model.entities.*;
import gov.iti.jets.utils.mappers.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HEAD;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.Timestamp;

@Path("category")
public class CategoryServicesImpl {

    @GET
    @Path("getCategory/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategoryById(@PathParam("id") int id) {
        CategoryRepoImpl categoryRepoImpl = new CategoryRepoImpl();

        if (categoryRepoImpl.getCategoryById(id) == null) {

            ErrorMessage errorMessage = new ErrorMessage("category id not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }
        return Response.ok().entity(CategoryMapper.INSTANCE.toDto(categoryRepoImpl.getCategoryById(id))).build();

    }

    @GET
    @Path("getAllCategories")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCategories() {
        CategoryRepoImpl categoryRepoImpl = new CategoryRepoImpl();
        ArrayList<Category> allCategories = categoryRepoImpl.getAllCategories();
        ArrayList<CategoryDto> allCategoriesDto = new ArrayList<>();
        for (int i = 0; i < allCategories.size(); i++) {

            allCategoriesDto.add(CategoryMapper.INSTANCE.toDto(allCategories.get(i)));
        }

        return Response.ok().entity(allCategoriesDto).build();

    }

    @GET
    @Path("getCategoryFilms/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategoryFilmsById(@PathParam("id") int id) {
        CategoryRepoImpl categoryRepoImpl = new CategoryRepoImpl();
        if (categoryRepoImpl.getCategoryFilmsById(id) == null) {

            ErrorMessage errorMessage = new ErrorMessage("category id not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }
        ArrayList<Film> films = categoryRepoImpl.getCategoryFilmsById(id);
        ArrayList<FilmDto> filmsDto = new ArrayList<>();
        for (int i = 0; i < films.size(); i++) {

            filmsDto.add(FilmMapper.INSTANCE.toDto(films.get(i)));
        }

        return Response.ok().entity(filmsDto).build();

    }

    @GET
    @Path("updateCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoryDto updateCategoryById(@QueryParam("id") int id, @QueryParam("name") String name) {
        CategoryRepoImpl categoryRepoImpl = new CategoryRepoImpl();
        if (categoryRepoImpl.updateCategoryById(id, name) == null) {

            ErrorMessage errorMessage = new ErrorMessage("category id not exist");
            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
            throw new WebApplicationException(response);
        }
        return CategoryMapper.INSTANCE.toDto(categoryRepoImpl.updateCategoryById(id, name));
    }

    @DELETE
    @Path("deleteCategory/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public int deleteCategoryById(@PathParam("id") int id) {
        CategoryRepoImpl categoryRepoImpl = new CategoryRepoImpl();

        return categoryRepoImpl.deleteCategoryById(id);
    }

    @POST
    @Path("createCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoryDto createCategory(CategoryDto categoryDto) {
        CategoryRepoImpl categoryRepoImpl = new CategoryRepoImpl();
        categoryDto.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        categoryRepoImpl.createCategory(CategoryMapper.INSTANCE.toEntity(categoryDto));
        return categoryDto;
    }

}
