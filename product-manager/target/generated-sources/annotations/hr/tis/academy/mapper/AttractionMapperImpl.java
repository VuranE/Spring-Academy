package hr.tis.academy.mapper;

import hr.tis.academy.dto.AttractionDto;
import hr.tis.academy.model.Attraction;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-11T13:30:21+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class AttractionMapperImpl implements AttractionMapper {

    @Override
    public AttractionDto toDto(Attraction attraction) {
        if ( attraction == null ) {
            return null;
        }

        AttractionDto attractionDto = new AttractionDto();

        attractionDto.setAttractionName( attraction.getAttractionName() );
        attractionDto.setDescription( attraction.getDescription() );
        attractionDto.setType( attraction.getType() );

        return attractionDto;
    }
}
