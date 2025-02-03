package hr.tis.academy.service;

import hr.tis.academy.model.AppUser;
import hr.tis.academy.model.TravelJournal;
import org.springframework.stereotype.Component;


public interface TravelJournalService {

    Long createJournal(TravelJournal journal);

    TravelJournal fetchJournalById(Long travelJournalId);


}
