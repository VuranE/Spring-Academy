package hr.tis.academy.repository;

import hr.tis.academy.model.AppUser;
import hr.tis.academy.model.Attraction;
import hr.tis.academy.model.TravelJournal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelJournalRepository extends JpaRepository<TravelJournal, Long> {

    @Query("select tj from TravelJournal tj where tj.id = :travelJournalId")
    TravelJournal findJournalById(Long travelJournalId);

}
