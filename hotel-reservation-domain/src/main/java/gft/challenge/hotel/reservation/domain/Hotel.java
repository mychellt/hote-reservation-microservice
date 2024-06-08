package gft.challenge.hotel.reservation.domain;

import gft.challenge.hotel.reservation.domain.exception.NoAvailableRoomsException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {
  private String name;
  private String email;
  private String phone;
  private Integer numberOfRooms;
  private Integer availableRooms;

  private boolean hasAvailableRooms(final int numberOfRequestedRooms) {
    return this.availableRooms >= numberOfRequestedRooms;
  }

  public void reserveRooms(int numberOfRequestedRooms) {
    if(!hasAvailableRooms(numberOfRequestedRooms)) {
      throw new NoAvailableRoomsException("No available rooms!");
    }
    this.availableRooms -= numberOfRequestedRooms;
  }

  public void cancelReservation(int numberOfRequestedRooms) {
    this.availableRooms += numberOfRequestedRooms;
  }
}
