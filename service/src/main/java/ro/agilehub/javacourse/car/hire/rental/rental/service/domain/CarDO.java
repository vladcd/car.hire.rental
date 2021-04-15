package ro.agilehub.javacourse.car.hire.rental.rental.service.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class CarDO {

    private Integer id;

}
