package gft.challenge.hotel.reservation.messaging.rabbitmq.consumer;

import gft.challenge.hotel.reservation.core.business.ReservationHotelPort;
import gft.challenge.hotel.reservation.core.command.Context;
import gft.challenge.hotel.reservation.domain.Reservation;
import gft.challenge.hotel.reservation.messaging.rabbitmq.model.HotelReservationMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HotelReservationConsumerAdapter {
  private final ReservationHotelPort reservationHotelPort;

  @Autowired
  public HotelReservationConsumerAdapter(final ReservationHotelPort reservationHotelPort) {
    this.reservationHotelPort = reservationHotelPort;
  }

  @RabbitListener(queues = "${app.messaging.hotel-reservation-queue}")
  public void process(final HotelReservationMessage message) {
    final Context context = new Context();

    final Reservation reservation =
        Reservation.builder()
            .numberOfRooms(message.getNumberOfRooms())
            .checkOutDate(message.getCheckOutDate())
            .checkInDate(message.getCheckInDate())
            .travelReservationId(message.getTravelReservationId())
            .hotelId(message.getHotelId())
            .build();

    context.setData(reservation);
    reservationHotelPort.process(context);
  }
}
