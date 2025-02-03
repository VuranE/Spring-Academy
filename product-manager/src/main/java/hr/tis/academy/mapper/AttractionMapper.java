package hr.tis.academy.mapper;

import hr.tis.academy.dto.AttractionDto;
import hr.tis.academy.model.Attraction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AttractionMapper {
    AttractionMapper INSTANCE = Mappers.getMapper(AttractionMapper.class);

    @Mapping(source = "attractionName", target = "attractionName")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "type", target = "type")
    AttractionDto toDto(Attraction attraction);

}
