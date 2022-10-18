package ro.agilehub.javacourse.car.hire.rental.rental.service.ports;

import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;

import java.util.Optional;

public interface RentalPort {

    Integer save(RentalDO rentalDO);

    Optional<RentalDO> getRental(Integer rentalId);
}
