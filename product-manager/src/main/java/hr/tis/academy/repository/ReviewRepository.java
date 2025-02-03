package hr.tis.academy.repository;


import hr.tis.academy.model.Attraction;
import hr.tis.academy.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReviewRepository  extends JpaRepository<Review, Long> {

    @Query("select r from Review r where r.attraction.attractionName = :name")
    List<Review> fetchReviewsByAttractionName(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM REVIEW LIMIT :_do - :od OFFSET :od")
    List<Review> fetchReviewsBetweenDates(Integer od, Integer _do);

}
