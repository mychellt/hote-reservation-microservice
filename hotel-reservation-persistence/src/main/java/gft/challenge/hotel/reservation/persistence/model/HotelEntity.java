package gft.challenge.hotel.reservation.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class HotelEntity {
  @Id
  @GeneratedValue(generator = "uuid")
  @Column(columnDefinition = "BINARY(16)")
  private UUID id;
  private String name;
  private String email;
  private String phone;

  @Column(name = "number_of_rooms")
  private Integer numberOfRooms;

  @Column(name = "available_rooms")
  private Integer availableRooms;
}
