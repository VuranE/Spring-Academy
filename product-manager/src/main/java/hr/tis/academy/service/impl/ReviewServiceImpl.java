package hr.tis.academy.service.impl;


import hr.tis.academy.model.Attraction;
import hr.tis.academy.model.Review;
import hr.tis.academy.repository.AttractionRepository;
import hr.tis.academy.repository.LocationRepository;
import hr.tis.academy.repository.ReviewRepository;
import hr.tis.academy.service.ReviewService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final AttractionRepository attractionRepository;
    private final LocationRepository locationRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, AttractionRepository attractionRepository, LocationRepository locationRepository) {
        this.reviewRepository = reviewRepository;
        this.attractionRepository = attractionRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public void insertReview(Review review) {
        attractionRepository.save(review.getAttraction());

        reviewRepository.save(review);
    }

    @Override
    public List<Review> fetchReviewsByAttractionName(String name) {
        return reviewRepository.fetchReviewsByAttractionName(name);
    }

    @Override
    public List<Review> fetchReviewsBetween(Integer from, Integer to) {
        return reviewRepository.fetchReviewsBetweenDates(from - 1, to);
    }
}
