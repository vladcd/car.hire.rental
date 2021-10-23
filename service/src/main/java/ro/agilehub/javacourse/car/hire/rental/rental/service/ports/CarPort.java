package ro.agilehub.javacourse.car.hire.rental.rental.service.ports;

import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.CarDO;

import java.util.Optional;

public interface CarPort {

    Optional<CarDO> findCar(Integer carId);
}
