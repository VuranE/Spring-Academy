package hr.tis.academy.service.impl;


import hr.tis.academy.model.Attraction;
import hr.tis.academy.model.Location;
import hr.tis.academy.repository.AttractionRepository;
import hr.tis.academy.repository.LocationRepository;
import hr.tis.academy.service.AttractionService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.core.io.Resource;



@Component
public class AttractionServiceImpl implements AttractionService {

    private final AttractionRepository aRepo;
    private final LocationRepository locRepo;

    @Autowired
    public AttractionServiceImpl(AttractionRepository aRepo, LocationRepository locRepo) {
        this.aRepo = aRepo;
        this.locRepo = locRepo;
    }


    @Override
    public List<Attraction> fetchAttractionByLocationName(String name) {

        return aRepo.fetchAttractionsByLocationName(name);
    }

    @Override
    public List<Attraction> fetchAttractionByLocation(Location location) {

        return aRepo.fetchAttractionsByLocation(location);
    }

    @Override
    public Attraction fetchAttractionByAttractionName(String name) {

        return aRepo.fetchAttractionsByAttractionName(name);

    }


    @Override
    public void insertAttraction(Attraction attraction) {

        String tempString = Normalizer.normalize(attraction.getAttractionName(), Normalizer.Form.NFKD);

        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        attraction.setAttractionName(pattern.matcher(tempString).replaceAll(""));
        aRepo.save(attraction);
    }

    @Override
    public Location fetchLocationByName(String location) {
        return locRepo.findByLocationName(location);
    }



}
