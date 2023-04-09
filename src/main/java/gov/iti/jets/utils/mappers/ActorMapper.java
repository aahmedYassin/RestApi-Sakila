package gov.iti.jets.utils.mappers;

import gov.iti.jets.model.dtos.ActorDto;
import gov.iti.jets.model.entities.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper 
public interface ActorMapper {

        ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);
        ActorDto toDto(Actor actor);
        Actor toEntity(ActorDto actorDto);

}
