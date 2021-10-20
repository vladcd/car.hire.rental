package ro.agilehub.javacourse.car.hire.rental.rental.repository.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.definition.RentalRepository;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.entity.Rental;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.mapper.RentalDOMapper;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.RentalPort;

@Service
@RequiredArgsConstructor
public class RentalDbAdapter implements RentalPort {

    private final RentalRepository rentalRepository;
    private final RentalDOMapper rentalDOMapper;

    @Override
    public Integer save(RentalDO input) {
        Rental newRental = rentalDOMapper.toRental(input);
        rentalRepository.save(newRental);
        return newRental.getId();
    }
}
