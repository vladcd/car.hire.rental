package ro.agilehub.javacourse.car.hire.rental.rental.service.ports;

import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.CarDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.UserDO;

import java.util.Optional;

public interface CarPort {
    Optional<CarDO> getCar(Integer carId);
}
