package hr.tis.academy.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface PictureService {

    String insertImage(String locationName, String attractionName, MultipartFile file);

    Resource getImage(String locationName, String attractionName, Long id);
}
