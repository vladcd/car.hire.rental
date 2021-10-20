package ro.agilehub.javacourse.car.hire.rental.rental.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ro.agilehub.javacourse.car.hire.rental.api.model.CreatedDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.RentalDTO;
import ro.agilehub.javacourse.car.hire.rental.api.specification.RentalApi;
import ro.agilehub.javacourse.car.hire.rental.rental.controller.mapper.RentalDTOMapper;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.RentalUseCase;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class RentalController implements RentalApi {

    private final RentalUseCase rentalUseCase;
    private final RentalDTOMapper rentalDTOMapper;

    @Override
    public ResponseEntity<CreatedDTO> addRental(@Valid RentalDTO rentalDTO) {
        var id = rentalUseCase.createNewRental(rentalDTOMapper.toRentalDO(rentalDTO));
        return ResponseEntity.ok(new CreatedDTO().id(id));
    }
}
