package gov.iti.jets.utils.mappers;

import gov.iti.jets.model.dtos.*;
import gov.iti.jets.model.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDto toDto(Address address);

    Address toEntity(AddressDto addressDto);

}
