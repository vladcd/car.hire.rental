package ro.agilehub.javacourse.car.hire.rental.rental.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.CarApi;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.definition.RentalRepository;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.RentalService;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalStatusDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.mapper.CarDOMapper;
import ro.agilehub.javacourse.car.hire.rental.rental.service.mapper.RentalDOMapper;
import ro.agilehub.javacourse.car.hire.rental.rental.service.mapper.UserDOMapper;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {
    private final UserApi userApi;
    private final CarApi carApi;
    private final RentalRepository rentalRepository;
    private final RentalDOMapper rentalDOMapper;

    private final UserDOMapper userDOMapper;

    private final CarDOMapper carDOMapper;

    @Override
    public Integer createNewRental(RentalDO example) {
        var userDTOResponse = userApi.getUser(example.getUser().getId());
        var carDTOResponse = carApi.getCar(example.getCar().getId());
        if (userDTOResponse.hasBody() && carDTOResponse.hasBody()) {
            example.setStatus(RentalStatusDO.ACTIVE);
            var rental = rentalDOMapper.toRental(example);
            return rentalRepository.save(rental).getId();
        }
        throw new NoSuchElementException();
    }

    @Override
    public RentalDO retrieveRental(Integer id) {
        var rental = rentalRepository.findById(id).orElseThrow();
        RentalDO rentalDO = rentalDOMapper.toRentalDO(rental);

        var userDTOResponse = userApi.getUser(rental.getUserId());
        if(userDTOResponse.hasBody()){
            rentalDO.setUser(userDOMapper.toUserDO(userDTOResponse.getBody()));
        }

        var carDTOResponse = carApi.getCar(rental.getCarId());
        if(carDTOResponse.hasBody()){
            rentalDO.setCar(carDOMapper.toCarDO(carDTOResponse.getBody()));
        }

        return rentalDO;
    }
}
