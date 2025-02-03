package hr.tis.academy.service.impl;

import hr.tis.academy.model.Picture;
import hr.tis.academy.repository.PictureRepository;
import hr.tis.academy.repository.exception.NoPictureFindException;
import hr.tis.academy.service.PictureService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public String insertImage(String locationName, String attractionName, MultipartFile file) {

        pictureRepository.save(new Picture(file.getOriginalFilename()));

        if (file.isEmpty()) {
            return "File is empty";
        }

        boolean exists = Files.exists(Path.of("src\\main\\resources\\images\\" + locationName + "\\" + attractionName));

        if (exists == true) {
            return saveImage(locationName, attractionName, file);
        } else {

            new File("src\\main\\resources\\images\\" + locationName + "\\" + attractionName).mkdirs();

            return saveImage(locationName, attractionName, file);
        }
    }

    @Override
    public Resource getImage(String locationName, String attractionName, Long id){

        Optional<Picture> optionalPicture = pictureRepository.findById(id);

        Picture picture = new Picture();

        if(optionalPicture.isPresent()){
            picture = optionalPicture.get();
        }
        else {
            throw new NoPictureFindException("Picture doesn't exist!");
        }

        Path path = Paths.get("src\\main\\resources\\images\\" + locationName + "\\" + attractionName+"\\"+picture.getName());

        try {

            Resource resource = new UrlResource(path.toUri());
            return resource;

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    private static String saveImage(String locationName, String attractionName, MultipartFile file) {

        try {
            Path destination = Paths.get("src\\main\\resources\\images\\" + locationName + "\\" + attractionName + "\\"+file.getOriginalFilename()).normalize();
            Files.copy(file.getInputStream(), destination);

            return "Image uploaded succesffully: " + file.getOriginalFilename();

        } catch (IOException e) {
            return "Failed to upload file";
        }
    }
}
