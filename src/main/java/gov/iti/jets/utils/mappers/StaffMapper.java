package gov.iti.jets.utils.mappers;

import gov.iti.jets.model.dtos.*;
import gov.iti.jets.model.entities.Film;
import gov.iti.jets.model.entities.Staff;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper 
public interface StaffMapper {

    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);
    StaffDto toDto(Staff staff);
    Staff toEntity(StaffDto staffDto);
}
