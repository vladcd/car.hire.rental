package ro.agilehub.javacourse.car.hire.rental.client.core.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.client.core.mapper.CarDOMapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.CarApi;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.CarDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.manager.CarManager;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CarManagerImpl implements CarManager {

    private final CarApi carApi;
    private final CarDOMapper carDOMapper;

    @Override
    public Optional<CarDO> getCar(Integer id) {
        return Optional.of(carApi.getCar(id))
                .map(ResponseEntity::getBody)
                .map(carDOMapper::toCarDO);
    }
}
