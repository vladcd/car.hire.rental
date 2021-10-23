package ro.agilehub.javacourse.car.hire.rental.rental.mongo.repository.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.agilehub.javacourse.car.hire.rental.rental.mongo.repository.entity.RentalDocument;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {TimestampMapper.class})
public interface RentalDocumentDOMapper {

    @Mapping(target = "carId", source = "car.id")
    @Mapping(target = "userId", source = "user.id")
    RentalDocument toRental(RentalDO rentalDO);

    default String generateId(Integer id) {
        return UUID.randomUUID().toString();
    }
}
