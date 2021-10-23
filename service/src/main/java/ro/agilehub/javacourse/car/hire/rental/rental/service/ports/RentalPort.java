package ro.agilehub.javacourse.car.hire.rental.rental.service.ports;

import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;

public interface RentalPort {

    Integer save(RentalDO rentalDO);
}
