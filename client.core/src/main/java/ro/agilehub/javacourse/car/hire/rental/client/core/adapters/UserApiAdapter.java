package ro.agilehub.javacourse.car.hire.rental.client.core.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.client.core.mappers.UserDOMapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.UserDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.UserPort;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserApiAdapter implements UserPort {

    private final UserApi userApi;

    private final UserDOMapper userDOMapper;

    @Override
    public Optional<UserDO> getUser(Integer userId) {
        var userDTO = userApi.getUser(userId);
        if(userDTO.hasBody()){
            return Optional.ofNullable(userDTO.getBody())
                    .map(userDOMapper::toUserDO);
        }
        return Optional.empty();
    }
}
