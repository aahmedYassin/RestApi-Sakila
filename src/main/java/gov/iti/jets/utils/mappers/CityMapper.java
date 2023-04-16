package gov.iti.jets.utils.mappers;

import gov.iti.jets.model.dtos.CityDto;
import gov.iti.jets.model.entities.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    CityDto toDto(City city);

    City toEntity(CityDto cityDto);

}
