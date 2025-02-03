package hr.tis.academy.dto;

import java.time.LocalDate;

public class JournalAttractionDto {
    private Long id;
    private String location;
    private String attraction;
    private String comment;
    private LocalDate date;
    public JournalAttractionDto(){

    }

    public JournalAttractionDto(Long id, String location, String attraction, String comment, LocalDate date) {
        this.id = id;
        this.location = location;
        this.attraction = attraction;
        this.comment = comment;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public String getAttraction() {
        return attraction;
    }

    public String getComment() {
        return comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAttraction(String attraction) {
        this.attraction = attraction;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
