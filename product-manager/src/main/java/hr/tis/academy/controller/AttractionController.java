package hr.tis.academy.controller;


import hr.tis.academy.dto.AttractionDto;
import hr.tis.academy.dto.AttractionReviewDto;
import hr.tis.academy.dto.LocationDto;
import hr.tis.academy.mapper.AttractionMapper;
import hr.tis.academy.model.Attraction;
import hr.tis.academy.service.AttractionService;
import hr.tis.academy.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attractions")
public class AttractionController {

    private final AttractionService attractionService;
    private final ReviewService reviewService;

    public AttractionController(AttractionService attractionService, ReviewService reviewService) {
        this.attractionService = attractionService;
        this.reviewService = reviewService;
    }

    @GetMapping("/{locationName}/{attractionName}/{excludeReviews}/{from}/{to}")
    public ResponseEntity<AttractionReviewDto> fetchAttraction(@PathVariable String locationName, @RequestParam String attractionName, @RequestParam (defaultValue = "false") String excludeReviews, @RequestParam (defaultValue = "1") Integer reviewsFrom, @RequestParam (defaultValue = "3") Integer reviewsTo) {

        AttractionReviewDto ardto = new AttractionReviewDto(AttractionMapper.INSTANCE.toDto(attractionService.fetchAttractionByAttractionName(attractionName)));

           if(excludeReviews.equals("false")) {
               ardto.setReviews(reviewService.fetchReviewsByAttractionName(attractionName));

               reviewService.fetchReviewsBetween(reviewsFrom, reviewsTo);


           }
        return ResponseEntity.ok().body(ardto);
    }

    @PostMapping("/image")
    public ResponseEntity<String> imageUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
        }

        try {
            byte[] bytes = file.getBytes();
            File uploadedFile = new File("proba.txt");
            file.transferTo(uploadedFile);

            return ResponseEntity.status(HttpStatus.CREATED).body("Image uploaded successfully: " + file.getOriginalFilename());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }


    @GetMapping("/{locationName}")
    public ResponseEntity<LocationDto> fetchAttractionByLocation(@PathVariable String locationName) {
        LocationDto locationDto = new LocationDto();

        locationDto.setLocation(locationName);
        for(Attraction attraction : attractionService.fetchAttractionByLocationName(locationName)) {
           locationDto.getAttractionDtoList().add(AttractionMapper.INSTANCE.toDto(attraction));
        }

        return ResponseEntity.ok().body(locationDto);
    }
}