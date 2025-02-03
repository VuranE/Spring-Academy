package hr.tis.academy.dto;

import hr.tis.academy.model.Attraction;
import hr.tis.academy.model.Review;
import hr.tis.academy.repository.ReviewRepository;

import java.util.ArrayList;
import java.util.List;

public class AttractionReviewDto {

    private AttractionDto attraction;
    private double average;
    private List<Review> reviews = new ArrayList<Review>();

    public AttractionReviewDto() {
        average = 0.0;
    }

    public AttractionReviewDto(AttractionDto attraction) {
        this.attraction = attraction;
        average = 0;
    }



    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public List<Review> getReviews() {
        return reviews;
    }

     public void setAverage()
     {

         for(Review review : reviews)
         {
             average += review.getRating();
         }
         average /= reviews.size();
     }
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
        setAverage();


    }

}
