package ro.agilehub.javacourse.car.hire.rental.client.core.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.client.core.mapper.UserDOMapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.UserDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.UserPort;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRestAdapter implements UserPort {
    private final UserApi userApi;
    private final UserDOMapper userDOMapper;

    @Override
    public Optional<UserDO> findUser(Integer userId) {
        return Optional.of(userApi.getUser(userId))
                .filter(ResponseEntity::hasBody)
                .map(ResponseEntity::getBody)
                .map(userDOMapper::toUserDO);
    }
}
