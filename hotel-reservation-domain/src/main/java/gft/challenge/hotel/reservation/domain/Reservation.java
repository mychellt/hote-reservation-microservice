package gft.challenge.hotel.reservation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.function.Predicate;

import static java.util.Objects.nonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {
  private Hotel hotel;
  private Guest guest;
  private LocalDateTime checkInDate;
  private LocalDateTime checkOutDate;
  private Integer numberOfRooms;
  private Status status;

  public boolean isCheckOutAllowed() {
    return nonNull(checkInDate) && checkOutDate.isAfter(checkInDate);
  }

  public void cancel() {
    this.status = Status.CANCELLED;
  }

  public void confirm() {
    this.status = Status.CONFIRMED;
  }

  private Predicate<LocalDateTime> isCheckInAllowedPredicate() {
    return now -> (now.isEqual(checkInDate) ||
        now.isAfter(checkInDate)) &&
        now.isBefore(checkOutDate) &&
        status == Status.CONFIRMED;
  }

  public boolean isCheckInAllowed() {
    return isCheckInAllowedPredicate().test(LocalDateTime.now());
  }

  public void updateNumberOfRooms(final int quantity) {
    if(quantity <= 0) {
      throw new IllegalArgumentException("Number of rooms must be greater than zero.");
    }
    this.numberOfRooms = quantity;
  }
}
