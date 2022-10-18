package ro.agilehub.javacourse.car.hire.rental.client.core.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.client.core.mappers.CarDOMapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.CarApi;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.CarDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.UserDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.CarPort;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CarApiAdapter implements CarPort {

    private final CarApi carApi;

    private final CarDOMapper carDOMapper;

    @Override
    public Optional<CarDO> getCar(Integer carId) {
        var carDTO = carApi.getCar(carId);
        if(carDTO.hasBody()){
            return Optional.ofNullable(carDTO.getBody())
                    .map(carDOMapper::toCarDO);
        }
        return Optional.empty();
    }
}
