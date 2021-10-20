package ro.agilehub.javacourse.car.hire.rental.rental.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.RentalUseCase;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalStatusDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.CarPort;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.RentalPort;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.UserPort;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class RentalUseCaseImpl implements RentalUseCase {
    private final UserPort userPort;
    private final CarPort carPort;
    private final RentalPort rentalPort;

    @Override
    public Integer createNewRental(RentalDO example) {
        var userDO = userPort.getUser(example.getUser().getId());
        var carDO = carPort.getCar(example.getCar().getId());
        if (userDO.isPresent() && carDO.isPresent()) {
            example.setStatus(RentalStatusDO.ACTIVE);
            return rentalPort.save(example);
        }
        throw new NoSuchElementException();
    }

}
