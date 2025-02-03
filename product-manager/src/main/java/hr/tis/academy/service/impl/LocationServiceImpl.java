package hr.tis.academy.service.impl;

import hr.tis.academy.model.Attraction;
import hr.tis.academy.model.Location;
import hr.tis.academy.repository.LocationRepository;
import hr.tis.academy.service.LocationService;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class LocationServiceImpl implements LocationService {

    private final LocationRepository locRepo;

    public LocationServiceImpl(LocationRepository locRepo) {
        this.locRepo = locRepo;
    }

    @Override
    public void insertLocation(Location location) {


        String tempString = Normalizer.normalize(location.getName(), Normalizer.Form.NFKD);

        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        location.setName(pattern.matcher(tempString).replaceAll(""));
        locRepo.save(location);

    }
}
