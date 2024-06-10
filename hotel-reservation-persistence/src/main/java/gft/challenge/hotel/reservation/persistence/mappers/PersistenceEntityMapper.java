package gft.challenge.hotel.reservation.persistence.mappers;


import gft.challenge.hotel.reservation.domain.Hotel;
import gft.challenge.hotel.reservation.domain.Reservation;
import gft.challenge.hotel.reservation.persistence.model.HotelEntity;
import gft.challenge.hotel.reservation.persistence.model.ReservationEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface PersistenceEntityMapper {

  Hotel from(final HotelEntity source);
  HotelEntity from(final Hotel source);

  @Mapping(target = "hotel.id", source = "hotelId")
  ReservationEntity from(final Reservation source);
  Reservation from(final ReservationEntity source);
}
