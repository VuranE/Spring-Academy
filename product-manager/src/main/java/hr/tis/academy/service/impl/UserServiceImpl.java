package hr.tis.academy.service.impl;

import hr.tis.academy.model.AppUser;
import hr.tis.academy.model.Attraction;
import hr.tis.academy.model.Favourite;
import hr.tis.academy.repository.AttractionRepository;
import hr.tis.academy.repository.FavouriteRepository;
import hr.tis.academy.repository.UserRepository;
import hr.tis.academy.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final FavouriteRepository favouriteRepository;
    private final AttractionRepository attractionRepository;

    public UserServiceImpl(UserRepository userRepository, FavouriteRepository favouriteRepository, AttractionRepository attractionRepository) {
        this.userRepository = userRepository;
        this.favouriteRepository = favouriteRepository;
        this.attractionRepository = attractionRepository;
    }

    public AppUser fetchUserByEmail(String email) {
        return userRepository.findAppUserByEmailJPQL(email);
    }

    @Override
    public AppUser fetchUserById(Long id) {
        return userRepository.findAppUserByIdJPQL(id);
    }

    @Override
    public Long insertUser(AppUser user) {
        AppUser tempUser = userRepository.save(user);
        return tempUser.getId();
    }

    public void saveFavourite(Favourite favourite)
    {
        favouriteRepository.save(favourite);
    }

    @Override
    public List<Favourite> fetchFavouritesByUser(Long userId) {
        return favouriteRepository.findByUserIdJPQL(userId);
    }

    @Override
    public void saveFavourite(Long userId, Attraction attraction) {
        Favourite favourite = new Favourite(userRepository.findAppUserByIdJPQL(userId),
                                            attractionRepository.fetchAttractionsById(attraction.getId()));
        favouriteRepository.save(favourite);
    }


}
