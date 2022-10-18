package ro.agilehub.javacourse.car.hire.rental.rental.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.RentalService;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalStatusDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.CarPort;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.RentalPort;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.UserPort;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {
    private final UserPort userPort;
    private final CarPort carPort;
    private final RentalPort rentalPort;
    @Override
    public Integer createNewRental(RentalDO example) {
        var userDTOResponse = userPort.getUser(example.getUser().getId());
        var carDTOResponse = carPort.getCar(example.getCar().getId());
        if (userDTOResponse.isPresent() && carDTOResponse.isPresent()) {
            example.setStatus(RentalStatusDO.ACTIVE);
            return rentalPort.save(example);
        }
        throw new NoSuchElementException();
    }

    @Override
    public RentalDO retrieveRental(Integer id) {
        var rentalDO = rentalPort.getRental(id).orElseThrow();

        userPort.getUser(rentalDO.getUser().getId())
                .ifPresent(rentalDO::setUser);

        carPort.getCar(rentalDO.getCar().getId())
                .ifPresent(rentalDO::setCar);

        return rentalDO;
    }
}
