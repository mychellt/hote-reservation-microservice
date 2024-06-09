package gft.challenge.hotel.reservation.http.resources.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FetchHotelDTO {
  private String name;
  private String phone;
  private String email;

  @JsonAlias(value = "number_of_rooms")
  private Integer numberOfRooms;

  @JsonAlias(value = "available_rooms")
  private Integer availableRooms;
}
