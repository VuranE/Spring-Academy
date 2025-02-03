package hr.tis.academy.mapper;

import hr.tis.academy.dto.AttractionDto;
import hr.tis.academy.dto.ReviewDto;
import hr.tis.academy.model.Attraction;
import hr.tis.academy.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);


    @Mapping(target = "timestamp", source = "reviewDto.timestamp")
    @Mapping(target = "rating", source = "reviewDto.rating")
    @Mapping(target = "reviewText", source = "reviewDto.reviewText")
    @Mapping(target = "attraction", source = "attraction")
    @Mapping(target = "id", ignore = true)
    Review dtoToClass(ReviewDto reviewDto, Attraction attraction);

}
