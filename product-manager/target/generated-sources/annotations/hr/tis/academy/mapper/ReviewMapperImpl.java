package hr.tis.academy.mapper;

import hr.tis.academy.dto.ReviewDto;
import hr.tis.academy.model.Attraction;
import hr.tis.academy.model.Review;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-11T13:30:21+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public Review dtoToClass(ReviewDto reviewDto, Attraction attraction) {
        if ( reviewDto == null && attraction == null ) {
            return null;
        }

        Review review = new Review();

        if ( reviewDto != null ) {
            review.setTimestamp( reviewDto.getTimestamp() );
            review.setRating( reviewDto.getRating() );
            review.setReviewText( reviewDto.getReviewText() );
        }
        review.setAttraction( attraction );

        return review;
    }
}
