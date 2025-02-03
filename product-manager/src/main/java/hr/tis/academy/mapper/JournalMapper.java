package hr.tis.academy.mapper;

import hr.tis.academy.dto.TravelJournalDto;
import hr.tis.academy.model.TravelJournal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JournalMapper {
    JournalMapper INSTANCE = Mappers.getMapper(JournalMapper.class);

    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "attractions", target = "attractions")
    @Mapping(source = "appUser", target = "appUser")
    @Mapping(target = "id", ignore = true)
    TravelJournal dtoToClass(TravelJournalDto journal);
}
