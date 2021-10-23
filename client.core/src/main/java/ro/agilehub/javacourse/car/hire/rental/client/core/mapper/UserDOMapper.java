package ro.agilehub.javacourse.car.hire.rental.client.core.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.UserDTO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.UserDO;

@Mapper(componentModel = "spring")
public interface UserDOMapper {

    UserDO toUserDO(UserDTO userDTO);
}
