package hr.tis.academy.controller;

import hr.tis.academy.dto.FavouriteRequestDto;
import hr.tis.academy.dto.UserDto;
import hr.tis.academy.dto.UserSaveRequestDto;
import hr.tis.academy.mapper.UserMapper;
import hr.tis.academy.mapper.UserSaveMapper;
import hr.tis.academy.model.Favourite;
import hr.tis.academy.repository.exception.InputIsNullException;
import hr.tis.academy.repository.exception.WrongInputException;
import hr.tis.academy.service.AttractionService;
import hr.tis.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final AttractionService attractionService;

    @Autowired
    public UserController(UserService userService, AttractionService attractionService, UserMapper userMapper) {
        this.userService = userService;
        this.attractionService = attractionService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId)
    {
        if(userService.fetchUserById(userId) == null)
        {
            throw new InputIsNullException("Korisnik ne postoji");
        }
        return ResponseEntity.ok().body(UserMapper.INSTANCE.toDto(userService.fetchUserById(userId)));
    }

    @GetMapping("/{userId}/favorites")
    public ResponseEntity<List<FavouriteRequestDto>> getFavourites(@PathVariable Long userId)
    {
        List<FavouriteRequestDto> favouritesDtoList = new ArrayList<>();

        for (Favourite favourite : userService.fetchFavouritesByUser(userId))
        {
            FavouriteRequestDto favouriteRequestDto = new FavouriteRequestDto(favourite.getAttraction().getAttractionName(),
                                                                            favourite.getAttraction().getLocation().getName());
            favouritesDtoList.add(favouriteRequestDto);
        }
        return ResponseEntity.ok().body(favouritesDtoList);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveUser(@RequestBody UserSaveRequestDto userSaveRequestDto)
    {
        if (userService.fetchUserByEmail(userSaveRequestDto.getEmail()) != null)
        {
            throw new WrongInputException("Već postoji korisnik s tim emailom");
        }
        if (userSaveRequestDto.getEmail().isEmpty() || userSaveRequestDto.getName().isEmpty())
        {
            throw new InputIsNullException("Name ili Email nesmiju biti prazni");
        }
        if (!Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$").matcher(userSaveRequestDto.getEmail()).matches())
        {
            throw new WrongInputException("Email nije u ispravnom formatu");
        }
        Long newUserId = userService.insertUser(UserSaveMapper.INSTANCE.dtoToClass(userSaveRequestDto));

        return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/user/" + newUserId).build();
    }

    @PostMapping("/{userId}/favorites")
    public ResponseEntity<HttpStatus> saveFavourite(@PathVariable Long userId,
                                                @RequestBody FavouriteRequestDto favouriteRequestDto)
    {
        if (favouriteRequestDto.getAttractionName() == null || favouriteRequestDto.getLocation() == null)
        {
            throw new InputIsNullException("Attraction name i location nesmiju biti prazni");
        }

        List<Favourite> checkFavouritesList = userService.fetchFavouritesByUser(userId);
        for (Favourite favourite : checkFavouritesList)
        {
            if (favourite.getAttraction().getAttractionName().equals(favouriteRequestDto.getAttractionName()))
            {
                throw new WrongInputException("Attraction je već spremljena kao favorit tog korisnika");
            }
        }

        userService.saveFavourite(userId, attractionService.fetchAttractionByAttractionName(favouriteRequestDto.getAttractionName()));

        return ResponseEntity.status(HttpStatus.CREATED).header("Content-Location", "/user/" + userId.toString() + "/favourites").build();
    }


}
