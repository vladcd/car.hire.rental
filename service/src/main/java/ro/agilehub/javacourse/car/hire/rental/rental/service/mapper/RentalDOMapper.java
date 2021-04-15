package ro.agilehub.javacourse.car.hire.rental.rental.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.UserDTO;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.entity.Rental;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;

@Mapper(componentModel = "spring", uses = {TimestampMapper.class})
public interface RentalDOMapper {

    @Mapping(target = "id", source = "rental.id")
    @Mapping(target = "car", source = "carDTO")
    @Mapping(target = "user", source = "userDTO")
    @Mapping(target = "status", source = "rental.status")
    RentalDO toRentalDO(Rental rental, UserDTO userDTO, CarDTO carDTO);

    @Mapping(target = "carId", source = "car.id")
    @Mapping(target = "userId", source = "user.id")
    Rental toRental(RentalDO rentalDO);
}
