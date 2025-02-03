package hr.tis.academy.controller;

import hr.tis.academy.service.PictureService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/attractions")
public class PictureController {

    private final PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @PostMapping("/{locationName}/{attractionName}/picture")
    public ResponseEntity<String> imageUpload(@PathVariable String locationName, @PathVariable String attractionName, @RequestParam("file") MultipartFile file) {

        String response = pictureService.insertImage(locationName, attractionName, file);

        if(response.equals("Image uploaded succesffully: " + file.getOriginalFilename())){
            return ResponseEntity.status(HttpStatus.CREATED).body("Image uploaded succesffully: " + file.getOriginalFilename());
        }
        if(response.equals("Failed to upload file")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to upload file");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
    }


    @GetMapping("/{locationName}/{attractionName}/picture/{pictureId}")
    public ResponseEntity<Resource> getImage(@PathVariable String locationName, @PathVariable String attractionName, @PathVariable Long pictureId)throws Exception {

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(pictureService.getImage(locationName, attractionName, pictureId));
    }

}
