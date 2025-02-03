package hr.tis.academy.mapper;

import hr.tis.academy.dto.UserDto;
import hr.tis.academy.model.AppUser;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-11T13:30:21+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(AppUser user) {
        if ( user == null ) {
            return null;
        }

        String name = null;
        String email = null;

        name = user.getName();
        email = user.getEmail();

        UserDto userDto = new UserDto( name, email );

        return userDto;
    }
}
