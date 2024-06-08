package gft.challenge.hotel.reservation.core.command.persistence;

import gft.challenge.hotel.reservation.domain.Hotel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HotelRepositoryPort {
  List<Hotel> getAll();
  Optional<Hotel> get(final UUID id);
  Hotel save(Hotel obj);
  void delete(final UUID id);
}
