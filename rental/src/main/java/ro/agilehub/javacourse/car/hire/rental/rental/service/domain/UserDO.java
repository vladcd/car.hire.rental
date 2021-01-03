package ro.agilehub.javacourse.car.hire.rental.rental.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ro.agilehub.javacourse.car.hire.rental.api.model.UserStatus;

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
