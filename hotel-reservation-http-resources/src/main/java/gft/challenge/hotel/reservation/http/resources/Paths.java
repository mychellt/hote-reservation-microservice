package gft.challenge.hotel.reservation.http.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class Paths {
  private static final String BASE = "/api";
  public static final String HOTEL = BASE + "/hotel";
}
