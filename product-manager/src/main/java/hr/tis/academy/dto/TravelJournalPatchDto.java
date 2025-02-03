package hr.tis.academy.dto;

import hr.tis.academy.model.JournalAttraction;

import java.time.LocalDate;

public class TravelJournalPatchDto {
    private LocalDate endDate;
    private String description;
    private JournalAttraction journalAttraction;

    public TravelJournalPatchDto(LocalDate endDate, String description, JournalAttraction journalAttraction) {
        this.endDate = endDate;
        this.description = description;
        this.journalAttraction = journalAttraction;
    }

    public TravelJournalPatchDto() {
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

    public JournalAttraction getJournalAttraction() {
        return journalAttraction;
    }

    public void setJournalAttraction(JournalAttraction journalAttraction) {
        this.journalAttraction = journalAttraction;
    }
}
