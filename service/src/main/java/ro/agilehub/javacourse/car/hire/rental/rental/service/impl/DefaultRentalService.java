package ro.agilehub.javacourse.car.hire.rental.rental.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.CarApi;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.definition.RentalRepository;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.RentalService;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalStatusDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.mapper.RentalDOMapper;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DefaultRentalService implements RentalService {
    private final UserApi userApi;
    private final CarApi carApi;
    private final RentalRepository rentalRepository;
    private final RentalDOMapper rentalDOMapper;

    @Override
    public Integer createNewRental(RentalDO example) {
        var userDTOResponseEntity = userApi.getUser(example.getUser().getId());
        var carDTOResponseEntity = carApi.getCar(example.getCar().getId());
        if (userDTOResponseEntity.hasBody() && carDTOResponseEntity.hasBody()) {
            example.setStatus(RentalStatusDO.ACTIVE);
            var newRental = rentalDOMapper.toRental(example);
            rentalRepository.save(newRental);
            return newRental.getId();
        }
        throw new NoSuchElementException();
    }

}
