package hr.tis.academy.controller;

import hr.tis.academy.dto.ReviewDto;
import hr.tis.academy.mapper.ReviewMapper;
import hr.tis.academy.model.Attraction;
import hr.tis.academy.model.Location;
import hr.tis.academy.model.Review;
import hr.tis.academy.repository.exception.InputIsNullException;
import hr.tis.academy.service.AttractionService;
import hr.tis.academy.service.ReviewService;
import hr.tis.academy.service.impl.AttractionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/attraction")
public class ReviewController {

    private final ReviewService reviewService;
    private final AttractionService attractionService;

    public ReviewController(ReviewService reviewService, AttractionService attractionService) {
        this.reviewService = reviewService;
        this.attractionService = attractionService;
    }

    @PostMapping("/review")
    public ResponseEntity<HttpStatus> insertReview(@RequestBody ReviewDto reviewDto)
    {
        Location tempLocation = attractionService.fetchLocationByName(reviewDto.getLocation());
        Attraction tempAttraction = attractionService.fetchAttractionByAttractionName(reviewDto.getAttractionName());

        if(tempAttraction == null)
        {
            throw new InputIsNullException("Attraction ne postoji");
        }

        if (!(reviewDto.getRating() >= 1 && reviewDto.getRating() <= 5))
        {
            throw new InputIsNullException("Ocjena mora biti između 1 i 5");
        }

        Review review = ReviewMapper.INSTANCE.dtoToClass(reviewDto, tempAttraction);
        reviewService.insertReview(review);
        return ResponseEntity.ok().body(HttpStatus.CREATED);
    }

}
