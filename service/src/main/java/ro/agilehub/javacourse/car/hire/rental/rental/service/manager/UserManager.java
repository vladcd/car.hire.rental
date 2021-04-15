package ro.agilehub.javacourse.car.hire.rental.rental.service.manager;

import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.CarDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.UserDO;

import java.util.Optional;

public interface UserManager {

    Optional<UserDO> getUser(Integer id);
}
