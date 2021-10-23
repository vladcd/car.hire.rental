package ro.agilehub.javacourse.car.hire.rental.rental.service.impl;

import lombok.RequiredArgsConstructor;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.RentalService;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalStatusDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.CarPort;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.RentalPort;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.UserPort;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class DefaultRentalService implements RentalService {
    private final UserPort userPort;
    private final CarPort carPort;
    private final RentalPort rentalPort;

    @Override
    public Integer createNewRental(RentalDO example) {
        var userDo = userPort.findUser(example.getUser().getId());
        var carDo = carPort.findCar(example.getCar().getId());
        if (userDo.isPresent() && carDo.isPresent()) {
            example.setStatus(RentalStatusDO.ACTIVE);
            return rentalPort.save(example);
        }
        throw new NoSuchElementException();
    }

}
