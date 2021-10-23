package ro.agilehub.javacourse.car.hire.rental.rental.mongo.repository.definition;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.agilehub.javacourse.car.hire.rental.rental.mongo.repository.entity.RentalDocument;

@Repository
public interface RentalDocumentRepository extends MongoRepository<RentalDocument, String> {
}
