package hr.tis.academy;

import hr.tis.academy.controller.AttractionController;
import hr.tis.academy.controller.UserController;
import hr.tis.academy.model.Attraction;
import hr.tis.academy.model.Location;
import hr.tis.academy.model.Review;
import hr.tis.academy.repository.AttractionRepository;
import hr.tis.academy.service.AttractionService;
import hr.tis.academy.service.ReviewService;
import hr.tis.academy.service.UserService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class App {

    private final AttractionService attractionService;
    private final UserController userController;
    private final ReviewService reviewService;
    public App(AttractionService attractionService, UserController userController, ReviewService reviewService) {
        this.attractionService = attractionService;
        this.userController = userController;
        this.reviewService = reviewService;
    }


    @Bean
    public ApplicationRunner applicationRunner()
    {
        return args -> {
            attractionService.insertAttraction(new Attraction("Plitvice", "Plitvicka jezera", "Priroda", new Location("Gorski kotar")));
            attractionService.insertAttraction(new Attraction("Durdevac Zoo", "Zooloski u durdevcu", "Zoo", new Location("Durdevac")));
            attractionService.insertAttraction(new Attraction("Trg Bana Josipa Jelačića", "Glavni trg u Zagrebu", "Trg", new Location("Zagreb")));
            reviewService.insertReview(new Review(LocalDateTime.now(), 5,  "Text", new Attraction("Poljana", "Glavni trg", "Trg", new Location("Split"))));
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
