package ro.agilehub.javacourse.car.hire.rental.rental.service.mapper;

import org.mapstruct.Mapper;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;

@Mapper(componentModel = "spring")
public interface TimestampMapper {

    default Timestamp toTimestamp(OffsetDateTime offsetDateTime) {
        return Timestamp.from(offsetDateTime.toInstant());
    }

    default OffsetDateTime toOffsetDateTime(Timestamp timestamp) {
        return OffsetDateTime.ofInstant(Instant.ofEpochMilli(timestamp.getTime()), ZoneId.systemDefault());
    }
}
