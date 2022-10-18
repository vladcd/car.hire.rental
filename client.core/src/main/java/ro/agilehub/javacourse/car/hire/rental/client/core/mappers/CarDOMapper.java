package ro.agilehub.javacourse.car.hire.rental.client.core.mappers;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarDTO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.CarDO;

@Mapper(componentModel = "spring")
public interface CarDOMapper {

    CarDO toCarDO(CarDTO carDTO);
}
