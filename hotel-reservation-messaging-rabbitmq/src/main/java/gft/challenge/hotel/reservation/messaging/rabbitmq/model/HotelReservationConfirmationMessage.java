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
public class HotelReservationConfirmationMessage {
  private UUID travelReservationId;
  private String guest;
  private Integer numberOfRooms;
  private LocalDateTime date;
}
