package ro.agilehub.javacourse.car.hire.rental.client.core.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.client.core.mapper.CarDOMapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.CarApi;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.CarDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.CarPort;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CarRestAdapter implements CarPort {
    private final CarApi carApi;
    private final CarDOMapper carDOMapper;

    @Override
    public Optional<CarDO> findCar(Integer carId) {
        return Optional.of(carApi.getCar(carId))
                .filter(ResponseEntity::hasBody)
                .map(ResponseEntity::getBody)
                .map(carDOMapper::toCarDO);
    }
}
