package hr.tis.academy.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "REVIEW")
public class Review
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDateTime timestamp;
    @Column
    private double rating;
    @Column
    private String reviewText;

    @ManyToOne
    @JoinColumn(name = "ATTRACTION_ID", nullable = false)
    private Attraction attraction;

    public Review() {
    }

    public Review(LocalDateTime timestamp, double rating, String reviewText/*, AppUser appUser*/, Attraction attraction) {
        this.timestamp = timestamp;
        this.rating = rating;
        this.reviewText = reviewText;
        /*this.appUser = appUser;*/
        this.attraction = attraction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }
}
