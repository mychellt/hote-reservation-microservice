package gft.challenge.hotel.reservation.http.resources.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateHotelDTO {
  private String name;
  private String email;
  private String phone;

  @JsonAlias(value = "number_of_rooms")
  private Integer numberOfRooms;
}
