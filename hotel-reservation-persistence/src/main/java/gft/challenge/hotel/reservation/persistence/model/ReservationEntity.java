package gft.challenge.hotel.reservation.persistence.model;

import gft.challenge.hotel.reservation.domain.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "reservations")
@Getter
@Setter
public class ReservationEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(columnDefinition = "UUID")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "hotel_id")
  private HotelEntity hotel;

  @Column(name = "check_in_date")
  private LocalDateTime checkInDate;

  @Column(name = "check_out_date")
  private LocalDateTime checkOutDate;

  @Column(name = "number_of_rooms")
  private Integer numberOfRooms;

  @Enumerated(EnumType.STRING)
  private Status status;

  @Column(name = "travel_reservation_id")
  private UUID travelReservationId;
}
