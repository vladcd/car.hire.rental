package ro.agilehub.javacourse.car.hire.rental.rental.repository.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.definition.RentalRepository;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.mappers.RentalDOMapper;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.RentalPort;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RentalDbAdapter implements RentalPort {

    private final RentalRepository rentalRepository;

    private final RentalDOMapper rentalDOMapper;

    @Override
    public Integer save(RentalDO rentalDO) {
        var rental = rentalDOMapper.toRental(rentalDO);
        return rentalRepository.save(rental).getId();
    }

    @Override
    public Optional<RentalDO> getRental(Integer rentalId) {
        return rentalRepository.findById(rentalId)
                .map(rentalDOMapper::toRentalDO);
    }
}
