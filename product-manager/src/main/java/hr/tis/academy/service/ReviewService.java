package hr.tis.academy.service;

import hr.tis.academy.model.Attraction;
import hr.tis.academy.model.Review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReviewService {

    void insertReview(Review review);

    List<Review> fetchReviewsByAttractionName(String name);
    List<Review> fetchReviewsBetween(Integer from, Integer to);

}
