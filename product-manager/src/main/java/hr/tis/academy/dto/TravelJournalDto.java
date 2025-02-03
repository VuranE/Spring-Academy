package hr.tis.academy.dto;

import hr.tis.academy.model.AppUser;

import java.time.LocalDate;
import java.util.Set;

public class TravelJournalDto {
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private Set<JournalAttractionDto> attractions;
    private AppUser appUser;

    public TravelJournalDto(LocalDate startDate, LocalDate endDate, String description, Set<JournalAttractionDto> attractions) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.attractions = attractions;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public Set<JournalAttractionDto> getAttractions() {
        return attractions;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAttractions(Set<JournalAttractionDto> attractions) {
        this.attractions = attractions;
    }
}
