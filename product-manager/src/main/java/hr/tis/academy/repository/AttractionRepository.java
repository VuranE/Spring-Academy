package hr.tis.academy.repository;

import hr.tis.academy.model.Attraction;
import hr.tis.academy.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {



    @Query("select a from Attraction a where a.location.name = :name")
    List<Attraction> fetchAttractionsByLocationName(String name);

    @Query("select a from Attraction a where a.attractionName = :name")
    Attraction fetchAttractionsByAttractionName(String name);


    @Query("select a from Attraction a where a.location.id = :location")
    List<Attraction> fetchAttractionsByLocation(Location location);

    @Query("select a from Attraction a where a.id = :id")
    Attraction fetchAttractionsById(Long id);
}
