package gov.iti.jets.utils.mappers;

import gov.iti.jets.model.dtos.*;
import gov.iti.jets.model.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper 
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto categoryDto);
}
