package gft.challenge.hotel.reservation.persistence.mappers;



import gft.challenge.hotel.reservation.domain.Hotel;
import gft.challenge.hotel.reservation.persistence.model.HotelEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface PersistenceEntityMapper {
  Hotel from(final HotelEntity source);
  HotelEntity from(final Hotel source);
}
