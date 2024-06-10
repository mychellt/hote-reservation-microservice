package gft.challenge.hotel.reservation.messaging.rabbitmq.publish;

import gft.challenge.hotel.reservation.core.messaging.HotelReservationConfirmationPublisherPort;
import gft.challenge.hotel.reservation.domain.Reservation;
import gft.challenge.hotel.reservation.messaging.rabbitmq.model.HotelReservationConfirmationMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class HotelReservationConfirmationPublisherAdapter implements HotelReservationConfirmationPublisherPort {
  @Value(value = "${app.messaging.hotel-reservation-confirmation-queue}")
  private String queue;
  private final RabbitTemplate rabbitTemplate;

  @Autowired
  public HotelReservationConfirmationPublisherAdapter(final RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }


  @Override
  public void send(Reservation reservation) {
    final HotelReservationConfirmationMessage message =
        HotelReservationConfirmationMessage.builder()
            .travelReservationId(reservation.getTravelReservationId())
            .date(LocalDateTime.now())
            .numberOfRooms(reservation.getNumberOfRooms())
            .build();
    rabbitTemplate.convertAndSend(queue, message);
  }
}
