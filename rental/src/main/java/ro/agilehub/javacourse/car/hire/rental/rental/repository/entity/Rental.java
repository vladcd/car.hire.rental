package ro.agilehub.javacourse.car.hire.rental.rental.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "rental")
@Data
@EqualsAndHashCode(of = "id")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer carId;
    private Timestamp startDate;
    private Timestamp endDate;
    private String status;

}

