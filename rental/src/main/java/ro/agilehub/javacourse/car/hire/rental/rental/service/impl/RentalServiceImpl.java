package ro.agilehub.javacourse.car.hire.rental.rental.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.RentalService;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.RentalDO;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final UserApi userApi;

    @Override
    public Integer createNewRental(RentalDO example) {
        var userDTOResponseEntity = userApi.getUser(example.getUser().getId());
        return 123;
    }
}
