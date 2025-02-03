package hr.tis.academy.repository;

import hr.tis.academy.model.AppUser;
import hr.tis.academy.model.Attraction;
import hr.tis.academy.model.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    @Query("select pm from AppUser pm where pm.email = :email")
    AppUser findAppUserByEmailJPQL(String email);

    @Query("select pm from AppUser pm where pm.id = :id")
    AppUser findAppUserByIdJPQL(Long id);


}
