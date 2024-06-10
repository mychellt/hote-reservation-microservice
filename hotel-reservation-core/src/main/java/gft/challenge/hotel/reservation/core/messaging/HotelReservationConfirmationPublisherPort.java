package gft.challenge.hotel.reservation.core.messaging;

import gft.challenge.hotel.reservation.domain.Reservation;

public interface HotelReservationConfirmationPublisherPort {
  void send(final Reservation reservation);
}
