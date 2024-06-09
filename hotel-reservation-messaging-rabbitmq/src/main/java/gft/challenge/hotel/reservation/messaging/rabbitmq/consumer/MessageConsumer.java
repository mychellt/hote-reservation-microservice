package gft.challenge.hotel.reservation.messaging.rabbitmq.consumer;

import gft.challenge.hotel.reservation.core.business.ReservationHotelPort;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
  private final ReservationHotelPort reservationHotelPort;

  @Autowired
  public MessageConsumer(ReservationHotelPort reservationHotelPort) {
    this.reservationHotelPort = reservationHotelPort;
  }

  @RabbitListener(queues = "hotel-reservation-queue")
  public void receiveMessage(String message) {

  }
}
