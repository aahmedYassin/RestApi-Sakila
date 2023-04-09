package gov.iti.jets.utils.mappers;

import gov.iti.jets.model.dtos.*;
import gov.iti.jets.model.entities.Film;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper 
public interface FilmMapper {

    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);
    FilmDto toDto(Film film);
    Film toEntity(FilmDto filmDto);
}
