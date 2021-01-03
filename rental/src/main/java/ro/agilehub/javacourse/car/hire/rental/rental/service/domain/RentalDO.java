package ro.agilehub.javacourse.car.hire.rental.rental.service.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.OffsetDateTime;

@Data
@EqualsAndHashCode(of = "id")
public class RentalDO {

    private Integer id;
    private UserDO user;
    private CarDO car;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private RentalStatusDO status;
}
