package hr.tis.academy.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "JOURNAL_ATTRACTION")
public class JournalAttraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String location;
    @Column
    private String attraction;
    @Column
    private String comment;
    @Column
    private LocalDate date;






    public JournalAttraction(String location, String attraction, String comment, LocalDate date) {
        this.location = location;
        this.attraction = attraction;
        this.comment = comment;
        this.date = date;
    }

    public JournalAttraction() {

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
