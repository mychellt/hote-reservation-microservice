package gft.challenge.hotel.reservation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Guest {
  private String name;
  private String email;
  private String phone;
}
