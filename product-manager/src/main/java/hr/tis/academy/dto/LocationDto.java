package hr.tis.academy.dto;

import java.util.ArrayList;
import java.util.List;

public class LocationDto {
    private String location;
    private List<AttractionDto> attractionDtoList = new ArrayList<>();

    public LocationDto(String location, List<AttractionDto> attractionDtoList) {
        this.location = location;
        this.attractionDtoList = attractionDtoList;
    }

    public LocationDto() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<AttractionDto> getAttractionDtoList() {
        return attractionDtoList;
    }

    public void setAttractionDtoList(List<AttractionDto> attractionDtoList) {
        this.attractionDtoList = attractionDtoList;
    }
}
