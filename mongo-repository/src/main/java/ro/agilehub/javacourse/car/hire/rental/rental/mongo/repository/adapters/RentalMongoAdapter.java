package ro.agilehub.javacourse.car.hire.rental.rental.mongo.repository.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.rental.mongo.repository.definition.RentalDocumentRepository;
import ro.agilehub.javacourse.car.hire.rental.rental.mongo.repository.mappers.RentalDocumentDOMapper;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.RentalPort;

@Component
@ConditionalOnProperty(name = "rental.feature.mongo", havingValue = "on")
@RequiredArgsConstructor
public class RentalMongoAdapter implements RentalPort {
    private final RentalDocumentRepository rentalDocumentRepository;
    private final RentalDocumentDOMapper rentalDocumentDOMapper;

    @Override
    public Integer save(RentalDO rentalDO) {
        rentalDocumentRepository.save(rentalDocumentDOMapper.toRental(rentalDO));
        return rentalDO.getId();
    }
}
