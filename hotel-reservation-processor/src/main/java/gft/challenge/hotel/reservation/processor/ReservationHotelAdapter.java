package gft.challenge.hotel.reservation.processor;

import gft.challenge.hotel.reservation.core.business.ReservationHotelPort;
import gft.challenge.hotel.reservation.core.command.Context;
import gft.challenge.hotel.reservation.core.messaging.HotelReservationConfirmationPublisherPort;
import gft.challenge.hotel.reservation.core.persistence.HotelRepositoryPort;
import gft.challenge.hotel.reservation.core.persistence.ReservationRepositoryPort;
import gft.challenge.hotel.reservation.domain.Reservation;
import gft.challenge.hotel.reservation.domain.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationHotelAdapter implements ReservationHotelPort {
  private final HotelRepositoryPort hotelRepositoryPort;
  private final ReservationRepositoryPort reservationRepositoryPort;

  private final HotelReservationConfirmationPublisherPort hotelReservationConfirmationPublisherPort;

  @Autowired
  public ReservationHotelAdapter(final HotelRepositoryPort hotelRepositoryPort,
                                 final ReservationRepositoryPort reservationRepositoryPort,
                                 final HotelReservationConfirmationPublisherPort hotelReservationConfirmationPublisherPort) {
    this.hotelRepositoryPort = hotelRepositoryPort;
    this.reservationRepositoryPort = reservationRepositoryPort;
    this.hotelReservationConfirmationPublisherPort = hotelReservationConfirmationPublisherPort;
  }

  @Override
  public Void process(Context context) {
    final Reservation reservation = context.getData(Reservation.class);
    reservation.setStatus(Status.CONFIRMED);

    reservationRepositoryPort.save(reservation);

    hotelReservationConfirmationPublisherPort.send(reservation);

    return null;
  }
}
