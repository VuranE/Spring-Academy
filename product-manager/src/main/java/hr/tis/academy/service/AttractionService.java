package hr.tis.academy.service;


import hr.tis.academy.dto.AttractionDto;
import hr.tis.academy.model.Attraction;
import hr.tis.academy.model.Location;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AttractionService {

     List<Attraction> fetchAttractionByLocationName(String name);

    List<Attraction> fetchAttractionByLocation(Location location);

    Attraction fetchAttractionByAttractionName(String name);

    void insertAttraction(Attraction attraction);

    Location fetchLocationByName(String location);


}
