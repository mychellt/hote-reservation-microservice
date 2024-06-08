package gft.challenge.hotel.reservation.domain.exception;

public class InvalidReservationDatesException extends RuntimeException {
  public InvalidReservationDatesException(final String message) {
    super(message);
  }
}
