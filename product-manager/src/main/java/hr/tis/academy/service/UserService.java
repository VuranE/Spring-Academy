package hr.tis.academy.service;


import hr.tis.academy.model.AppUser;
import hr.tis.academy.model.Attraction;
import hr.tis.academy.model.Favourite;

import java.util.List;

public interface UserService {
    AppUser fetchUserByEmail(String email);
    AppUser fetchUserById(Long id);
    Long insertUser(AppUser user);
    List<Favourite> fetchFavouritesByUser(Long userId);
    void saveFavourite(Long userId, Attraction attraction);
}
