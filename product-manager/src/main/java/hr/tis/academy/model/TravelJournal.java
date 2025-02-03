package hr.tis.academy.model;

import hr.tis.academy.dto.JournalAttractionDto;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="TRAVEL_JOURNAL")
public class TravelJournal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate = null; //OVO NIJE OBAVEZNO POLJE PROVJERI
    @Column
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "JOURNAL_ATTRACTION_ID", nullable = false)//PROVJERI OVO
    private Set<JournalAttraction> attractions;


    @ManyToOne
    @JoinColumn(name = "APPUSER_ID", nullable = false)
    private AppUser appUser;


    public TravelJournal(LocalDate startDate, LocalDate endDate, String description, Set<JournalAttraction> attractions, Long id, AppUser appUser) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.attractions = attractions;
        this.id = id;
        this.appUser = appUser;
    }

    public TravelJournal(LocalDate startDate, LocalDate endDate, String description, Set<JournalAttraction> attractions, AppUser appUser) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.attractions = attractions;
        this.appUser = appUser;
    }

    public TravelJournal() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<JournalAttraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(Set<JournalAttraction> attractions) {
        this.attractions = attractions;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}