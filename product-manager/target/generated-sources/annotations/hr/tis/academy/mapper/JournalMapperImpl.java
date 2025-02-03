package hr.tis.academy.mapper;

import hr.tis.academy.dto.JournalAttractionDto;
import hr.tis.academy.dto.TravelJournalDto;
import hr.tis.academy.model.JournalAttraction;
import hr.tis.academy.model.TravelJournal;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-11T13:30:21+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class JournalMapperImpl implements JournalMapper {

    @Override
    public TravelJournal dtoToClass(TravelJournalDto journal) {
        if ( journal == null ) {
            return null;
        }

        TravelJournal travelJournal = new TravelJournal();

        travelJournal.setStartDate( journal.getStartDate() );
        travelJournal.setEndDate( journal.getEndDate() );
        travelJournal.setDescription( journal.getDescription() );
        travelJournal.setAttractions( journalAttractionDtoSetToJournalAttractionSet( journal.getAttractions() ) );
        travelJournal.setAppUser( journal.getAppUser() );

        return travelJournal;
    }

    protected JournalAttraction journalAttractionDtoToJournalAttraction(JournalAttractionDto journalAttractionDto) {
        if ( journalAttractionDto == null ) {
            return null;
        }

        JournalAttraction journalAttraction = new JournalAttraction();

        journalAttraction.setLocation( journalAttractionDto.getLocation() );
        journalAttraction.setAttraction( journalAttractionDto.getAttraction() );
        journalAttraction.setComment( journalAttractionDto.getComment() );
        journalAttraction.setDate( journalAttractionDto.getDate() );
        journalAttraction.setId( journalAttractionDto.getId() );

        return journalAttraction;
    }

    protected Set<JournalAttraction> journalAttractionDtoSetToJournalAttractionSet(Set<JournalAttractionDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<JournalAttraction> set1 = new LinkedHashSet<JournalAttraction>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( JournalAttractionDto journalAttractionDto : set ) {
            set1.add( journalAttractionDtoToJournalAttraction( journalAttractionDto ) );
        }

        return set1;
    }
}
