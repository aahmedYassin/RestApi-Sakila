package gov.iti.jets.utils.mappers;

import gov.iti.jets.model.dtos.*;
import gov.iti.jets.model.entities.Customer;
import gov.iti.jets.model.entities.Film;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper 
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerDto toDto(Customer customer);
    Customer toEntity(CustomerDto customerDto);
}
