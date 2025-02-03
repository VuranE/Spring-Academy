package hr.tis.academy.mapper;

import hr.tis.academy.dto.UserDto;
import hr.tis.academy.dto.UserSaveRequestDto;
import hr.tis.academy.model.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    UserDto toDto(AppUser user);
}
