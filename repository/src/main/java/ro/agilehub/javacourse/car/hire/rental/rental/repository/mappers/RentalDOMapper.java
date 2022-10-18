package ro.agilehub.javacourse.car.hire.rental.rental.repository.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.entity.Rental;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;

@Mapper(componentModel = "spring", uses = {TimestampMapper.class})
public interface RentalDOMapper {

    @Mapping(target = "carId", source = "car.id")
    @Mapping(target = "userId", source = "user.id")
    Rental toRental(RentalDO rentalDO);

    RentalDO toRentalDO(Rental rental);
}
