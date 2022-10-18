package ro.agilehub.javacourse.car.hire.rental.rental.service.ports;

import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.UserDO;

import java.util.Optional;

public interface UserPort {

    Optional<UserDO> getUser(Integer userId);
}
