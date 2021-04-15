package ro.agilehub.javacourse.car.hire.rental.client.core.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.client.core.mapper.UserDOMapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.UserDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.manager.UserManager;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserManagerImpl implements UserManager {

    private final UserApi userApi;
    private final UserDOMapper userDOMapper;

    @Override
    public Optional<UserDO> getUser(Integer id) {
        return Optional.of(userApi.getUser(id))
                .map(ResponseEntity::getBody)
                .map(userDOMapper::toUserDO);
    }
}
