package gft.challenge.hotel.reservation.processor;

import gft.challenge.hotel.reservation.core.business.ReservationHotelPort;
import gft.challenge.hotel.reservation.core.command.Context;
import org.springframework.stereotype.Service;

@Service
public class ReservationHotelAdapter implements ReservationHotelPort {
  @Override
  public Void process(Context context) {
    return null;
  }
}
