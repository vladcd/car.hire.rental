package ro.agilehub.javacourse.car.hire.rental.rental.service.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class UserDO {

    private Integer id;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String driverLicense;
    private UserStatusDO status;

}
