package hr.tis.academy.dto;

import java.time.LocalDateTime;

public class ReviewDto {
    private String location;
    private String attractionName;
    private LocalDateTime timestamp;
    private double rating;
    private String reviewText;

    public ReviewDto(String location, String attractionName, LocalDateTime timestamp, double rating, String reviewText) {
        this.location = location;
        this.attractionName = attractionName;
        this.timestamp = timestamp;
        this.rating = rating;
        this.reviewText = reviewText;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
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
}
