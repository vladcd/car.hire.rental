package ro.agilehub.javacourse.car.hire.rental.rental.mongo.repository.entity;

import lombok.Data;

import java.sql.Timestamp;
import org.springframework.data.annotation.Id;

@Data
public class RentalDocument {

    @Id
    private String id;
    private Integer userId;
    private Integer carId;
    private Timestamp startDate;
    private Timestamp endDate;
    private String status;

}
