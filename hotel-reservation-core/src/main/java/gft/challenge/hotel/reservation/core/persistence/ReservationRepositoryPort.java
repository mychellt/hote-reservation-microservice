package gft.challenge.hotel.reservation.core.persistence;

import gft.challenge.hotel.reservation.domain.Reservation;

public interface ReservationRepositoryPort {
  Reservation save(final Reservation reservation);
}
