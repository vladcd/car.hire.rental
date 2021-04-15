package ro.agilehub.javacourse.car.hire.rental.rental.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.RentalService;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalStatusDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.manager.CarManager;
import ro.agilehub.javacourse.car.hire.rental.rental.service.manager.RentalManager;
import ro.agilehub.javacourse.car.hire.rental.rental.service.manager.UserManager;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DefaultRentalService implements RentalService {
    private final UserManager userManager;
    private final CarManager carManager;
    private final RentalManager rentalManager;

    @Override
    public Integer createNewRental(RentalDO example) {
        var userDO = userManager.getUser(example.getUser().getId());
        var carDO = carManager.getCar(example.getCar().getId());
        if (userDO.isPresent() && carDO.isPresent()) {
            example.setStatus(RentalStatusDO.ACTIVE);
            return rentalManager.save(example);
        }
        throw new NoSuchElementException();
    }

}
