package ro.agilehub.javacourse.car.hire.rental.rental.repository.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.definition.RentalRepository;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.mapper.RentalDOMapper;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.manager.RentalManager;

@Component
@RequiredArgsConstructor
public class DefaultRentalManager implements RentalManager {

    private final RentalRepository rentalRepository;
    private final RentalDOMapper rentalDOMapper;

    @Override
    public Integer save(RentalDO rentalDO) {
        var newRental = rentalDOMapper.toRental(rentalDO);
        rentalRepository.save(newRental);
        return newRental.getId();
    }
}
