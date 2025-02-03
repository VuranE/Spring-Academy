package hr.tis.academy.mapper;

import hr.tis.academy.dto.UserSaveRequestDto;
import hr.tis.academy.model.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserSaveMapper {
    UserSaveMapper INSTANCE = Mappers.getMapper(UserSaveMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(target = "id", ignore = true)
    AppUser dtoToClass(UserSaveRequestDto userSaveRequestDto);
}
