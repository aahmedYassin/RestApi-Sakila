package gov.iti.jets.utils.mappers;

import gov.iti.jets.model.dtos.*;
import gov.iti.jets.model.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    CountryDto toDto(Country country);

    Country toEntity(CountryDto countryDto);

}
