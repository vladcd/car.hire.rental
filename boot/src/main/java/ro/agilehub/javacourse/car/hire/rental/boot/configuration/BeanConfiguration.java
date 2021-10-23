package ro.agilehub.javacourse.car.hire.rental.boot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.RentalService;
import ro.agilehub.javacourse.car.hire.rental.rental.service.impl.DefaultRentalService;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.CarPort;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.RentalPort;
import ro.agilehub.javacourse.car.hire.rental.rental.service.ports.UserPort;

@Configuration
public class BeanConfiguration {

    @Bean
    public RentalService rentalService(UserPort userPort, CarPort carPort, RentalPort rentalPort){
        return new DefaultRentalService(userPort, carPort, rentalPort);
    }
}
