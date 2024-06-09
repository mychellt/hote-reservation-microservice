package gft.challenge.hotel.reservation.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "hotels")
@Getter
@Setter
public class HotelEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(columnDefinition = "UUID")
  private UUID id;
  private String name;
  private String email;
  private String phone;

  @Column(name = "number_of_rooms")
  private Integer numberOfRooms;

  @Column(name = "available_rooms")
  private Integer availableRooms;
}
