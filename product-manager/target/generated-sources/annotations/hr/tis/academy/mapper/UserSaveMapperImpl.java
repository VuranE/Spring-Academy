package hr.tis.academy.mapper;

import hr.tis.academy.dto.UserSaveRequestDto;
import hr.tis.academy.model.AppUser;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-11T13:30:21+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class UserSaveMapperImpl implements UserSaveMapper {

    @Override
    public AppUser dtoToClass(UserSaveRequestDto userSaveRequestDto) {
        if ( userSaveRequestDto == null ) {
            return null;
        }

        AppUser appUser = new AppUser();

        appUser.setName( userSaveRequestDto.getName() );
        appUser.setEmail( userSaveRequestDto.getEmail() );

        return appUser;
    }
}
