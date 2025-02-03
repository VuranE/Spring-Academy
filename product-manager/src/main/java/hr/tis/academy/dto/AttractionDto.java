package hr.tis.academy.dto;


import hr.tis.academy.model.AppUser;

public class AttractionDto {


    private String attractionName;
    private String description;
    private String type;
    private AppUser appUser;


    public AttractionDto() {
    }

    public AttractionDto(String attractionName, String description, String type) {
        this.attractionName = attractionName;
        this.description = description;
        this.type = type;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
