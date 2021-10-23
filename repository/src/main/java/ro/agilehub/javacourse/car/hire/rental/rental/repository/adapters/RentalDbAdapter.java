package ro.agilehub.javacourse.car.hire.rental.rental.repository.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.definition.RentalRepository;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.mappers.RentalDOMapper;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.RentalPort;

@Component
@ConditionalOnProperty(name = "rental.feature.mongo", havingValue = "off", matchIfMissing = true)
@RequiredArgsConstructor
public class RentalDbAdapter implements RentalPort {
    private final RentalRepository rentalRepository;
    private final RentalDOMapper rentalDOMapper;

    @Override
    public Integer save(RentalDO rentalDO) {
        var newRental = rentalDOMapper.toRental(rentalDO);
        rentalRepository.save(newRental);
        return newRental.getId();
    }
}
