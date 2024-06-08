package gft.challenge.hotel.reservation.domain.exception;

public class NoAvailableRoomsException extends RuntimeException{
  public NoAvailableRoomsException(String message) {
    super(message);
  }
}
