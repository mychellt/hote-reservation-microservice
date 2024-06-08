package gft.challenge.hotel.reservation.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@AllArgsConstructor
@Getter
public enum Status {
  CONFIRMED("Confirmed"),
  CANCELLED("Cancelled"),
  PENDING("Conexão Perida");

  private final String description;

  private static final Map<String, Status> MAP_STRING = new HashMap<>();

  static {
    for(final Status event : EnumSet.allOf(Status.class)) {
      MAP_STRING.put(event.name().toLowerCase(), event);
    }
  }

  public static Status entryOff(final String value) {
    return isNotBlank(value) ? MAP_STRING.get(value.toLowerCase()) : null;
  }
}
