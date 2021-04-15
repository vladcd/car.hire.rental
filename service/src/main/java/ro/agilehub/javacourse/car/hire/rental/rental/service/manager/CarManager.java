package ro.agilehub.javacourse.car.hire.rental.rental.service.manager;

import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.CarDO;

import java.util.Optional;

public interface CarManager {

    Optional<CarDO> getCar(Integer id);
}
