package gft.challenge.hotel.reservation.messaging.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HotelReservationMessage {
  private UUID hotelId;
  private LocalDateTime checkInDate;
  private LocalDateTime checkOutDate;
  private Integer numberOfRooms;
  private UUID travelReservationId;
}
