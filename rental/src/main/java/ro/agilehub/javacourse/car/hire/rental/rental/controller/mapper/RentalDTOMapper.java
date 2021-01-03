package ro.agilehub.javacourse.car.hire.rental.rental.controller.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.rental.api.model.RentalDTO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;

@Mapper(componentModel = "spring")
public interface RentalDTOMapper {

    RentalDO toRentalDO(RentalDTO rentalDTO);

    RentalDTO toRentalDTO(RentalDO rentalDO);
}
