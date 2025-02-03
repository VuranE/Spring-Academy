package hr.tis.academy.repository;

import hr.tis.academy.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long>
{
    @Query("select l from Location l where l.name = :locationName")
    Location findByLocationName(String locationName);


}
