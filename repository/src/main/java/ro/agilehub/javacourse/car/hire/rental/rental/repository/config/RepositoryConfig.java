package ro.agilehub.javacourse.car.hire.rental.rental.repository.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.definition.RentalRepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = RentalRepository.class)
public class RepositoryConfig {

}
