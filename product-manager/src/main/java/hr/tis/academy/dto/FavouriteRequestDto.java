package hr.tis.academy.dto;


public class FavouriteRequestDto {
    private String location;
    private String attractionName;

    public FavouriteRequestDto(String location, String attractionName) {
        this.location = location;
        this.attractionName = attractionName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }
}
