package hr.tis.academy.service.impl;

import hr.tis.academy.model.AppUser;
import hr.tis.academy.model.TravelJournal;
import hr.tis.academy.repository.TravelJournalRepository;
import hr.tis.academy.service.TravelJournalService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TravelJournalServiceImpl implements TravelJournalService {

    private final TravelJournalRepository journalRepository;

    public TravelJournalServiceImpl(TravelJournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    @Override
    public Long createJournal(TravelJournal journal) {
        TravelJournal temp = journalRepository.save(journal);
        return temp.getId();
    }

    @Override
    public TravelJournal fetchJournalById(Long travelJournalId) {
  return new TravelJournal();
    }
}
