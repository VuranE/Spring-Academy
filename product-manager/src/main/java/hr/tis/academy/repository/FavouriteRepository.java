package hr.tis.academy.repository;

import hr.tis.academy.model.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long> {

    @Query("select f from Favourite f where f.appUser.id = :userId")
    List<Favourite> findByUserIdJPQL(Long userId);
}
